package pl.iosx.quiz4wp.model.services.ApiManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

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

    @Inject
    public ApiManager(Context context)
    {
        apiService = new ApiService(context);
    }

    public void getAllEmptyQuizModelsAsync(final ApiResponseListener apiResponseListener)
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

    @SuppressLint("StaticFieldLeak")
    AsyncTask<Void,Integer,Integer> downloadAllQuizWithContentTask = new AsyncTask<Void, Integer, Integer>() {
        @Override
        protected Integer doInBackground(Void... voids) {
            List<ApiQuizItem> list = apiService.getListResponse();
            List<QuizModel> models = new ArrayList<>();
            int count = 0;
            for(ApiQuizItem item : list)
            {
                QuizModel model = new QuizModel(item);
                apiService.getQuizContent(model.getId());
                models.add(model);
                count++;
                publishProgress((count*100)/list.size());
            }

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled(Integer integer) {
            super.onCancelled(integer);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
    };

    public interface ApiResponseListener
    {
        void onReceived(List<QuizModel> models);
        void onFailure();
    }
}
