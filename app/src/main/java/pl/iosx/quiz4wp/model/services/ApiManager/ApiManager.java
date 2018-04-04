package pl.iosx.quiz4wp.model.services.ApiManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import pl.iosx.quiz4wp.model.data.dataUnit.ApiQuizContent;
import pl.iosx.quiz4wp.model.data.dataUnit.ApiQuizItem;
import pl.iosx.quiz4wp.model.data.dataUnit.ApiQuizListResponse;
import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by lukaszwroblewski on 01.04.2018.
 */
@Singleton
public class ApiManager {

    ApiService apiService;
    OperationListener operationListener;
    AsyncTask<List<QuizModel>, Integer, List<QuizModel>> asyncTask;

    public ApiManager(Context context)
    {
        apiService = new ApiService(context);
    }

    public void cancel()
    {
        if(asyncTask!=null && asyncTask.getStatus().equals(AsyncTask.Status.RUNNING))
        {
            asyncTask.cancel(true);
        }
    }

    private void reportCancel()
    {
        if(operationListener !=null)
        {
            operationListener.onCanceled();
            operationListener = null;
        }
    }

    private void reportFinish()
    {
        if(operationListener !=null)
        {
            operationListener.onFinish();
            operationListener = null;
        }
    }

    private void reportProgressChange(int percent) {
        if (operationListener != null) {
            operationListener.onProgressChange(percent);
        }
    }

    DownloadListListener downloadListListener = null;
    public void downloadContentForQuizList(final List<QuizModel> quizModelList, final DownloadListListener downloadListListener)
    {
        this.operationListener = downloadListListener;
        this.downloadListListener = downloadListListener;
        @SuppressLint("StaticFieldLeak")
        AsyncTask<List<QuizModel>,Integer,List<QuizModel>> downloadAllQuizWithContentTask = new AsyncTask<List<QuizModel>, Integer, List<QuizModel>>() {
            @Override
            protected List<QuizModel> doInBackground(List<QuizModel>... lists) {

                List<QuizModel> quizModels = null;
                if(lists!=null && lists.length>0)
                {
                    quizModels = lists[0];
                    int count = 0;
                    for(QuizModel model : quizModels)
                    {
                        ApiQuizContent content = apiService.getQuizContent(model.getId());
                        if(content!=null)
                        {
                            model.update(content);
                        }
                        count++;
                        publishProgress((count*100)/quizModels.size());
                    }
                }
                return quizModels;
            }

            @Override
            protected void onPostExecute(List<QuizModel> list) {
                super.onPostExecute(list);
                if(downloadListListener!=null) downloadListListener.onDownload(list);
                reportFinish();
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                if(values!=null && values.length>0)
                    reportProgressChange(values[0]);
            }

            @Override
            protected void onCancelled(List<QuizModel> models) {
                super.onCancelled(models);
                reportCancel();
            }

            @Override
            protected void onCancelled() {
                super.onCancelled();
                reportCancel();
            }
        };
        this.asyncTask = downloadAllQuizWithContentTask;
        downloadAllQuizWithContentTask.execute(quizModelList);

    }

    public void downloadAllEmptyQuizModelsAsync(final ApiResponseListener apiResponseListener)
    {
        apiService.getQuizResponseAsync(new IResponseListener<ApiQuizListResponse>() {
            @Override
            public void onSuccessfulResponse(Call<ApiQuizListResponse> call, Response<ApiQuizListResponse> responseResponse) {
               try
               {
                    List<ApiQuizItem> items = responseResponse.body().getApiQuizItemItems();
                    List<QuizModel> models = new ArrayList<>();
                    for(ApiQuizItem item : items)
                    {
                        models.add(new QuizModel(item));
                    }
                    apiResponseListener.onReceived(models);
               }
               catch (Exception e)
               {
                   apiResponseListener.onFailure();
               }
            }

            @Override
            public void onFailureResponse(Call<ApiQuizListResponse> call, Response<ApiQuizListResponse> responseResponse) {
                apiResponseListener.onFailure();
            }

            @Override
            public void onFailure(Call<ApiQuizListResponse> call, Throwable t) {
                apiResponseListener.onFailure();
            }

            @Override
            public void onError(Exception e) {
                apiResponseListener.onFailure();
            }
        });
    }



    public interface ApiResponseListener
    {
        void onReceived(List<QuizModel> models);
        void onFailure();
    }

    public interface OperationListener
    {
        void onFinish();
        void onCanceled();
        void onProgressChange(int percent);
    }

    public interface DownloadListListener extends OperationListener
    {
        void onDownload(List<QuizModel> models);
    }
}
