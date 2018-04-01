package pl.iosx.quiz4wp.model.services.DbManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

import com.j256.ormlite.support.ConnectionSource;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;

/**
 * Created by lukaszwroblewski on 29.03.2018.
 */

public class DbManager {

    private Context context;
    MyDatabaseHelper myDatabaseHelper;
    ConnectionSource connectionSource;
    OperationListener operationListener;

    AsyncTask<Void,Void,Void> clearAsyncTask;
    AsyncTask<List<QuizModel>,Integer,Void> addItemsAsyncTask;
    private AsyncTask<Void, Void, List<QuizModel>> getListAsyncTask;

    public DbManager(Context context)
    {
        this.context = context;
        this.myDatabaseHelper = new MyDatabaseHelper(context);
    }

    public void cancelRunningTasks()
    {
        if(clearAsyncTask!=null && clearAsyncTask.getStatus()== AsyncTask.Status.RUNNING)
        {
            clearAsyncTask.cancel(true);
            reportCancel();
        }
        if(addItemsAsyncTask!=null && addItemsAsyncTask.getStatus()== AsyncTask.Status.RUNNING)
        {
            addItemsAsyncTask.cancel(true);
            reportCancel();
        }
        if(getListAsyncTask!=null && getListAsyncTask.getStatus()== AsyncTask.Status.RUNNING)
        {
            getListAsyncTask.cancel(true);
            reportCancel();
        }
    }

    public void clearDataBase()
    {
        myDatabaseHelper.clearDataBase();
    }

    public void clearDataBaseAsync(OperationListener listener)
    {
        cancelRunningTasks();
        operationListener = listener;
        @SuppressLint("StaticFieldLeak")
        AsyncTask<Void,Void,Void> clearDataBaseTask = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                clearDataBase();
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                reportFinish();
            }

            @Override
            protected void onCancelled(Void aVoid) {
                super.onCancelled(aVoid);
                reportCancel();
            }

            @Override
            protected void onCancelled() {
                super.onCancelled();
                reportCancel();
            }
        };
        clearDataBaseTask.execute();
    }

    public List<QuizModel> getAllQuizModels()
    {
        return myDatabaseHelper.querryForAllQuizModels();
    }

    ReadDataBaseListener readDataBaseListener;
    public void getAllQuizModelsAsync(ReadDataBaseListener operationListener)
    {
        cancelRunningTasks();
        this.operationListener = operationListener;
        this.readDataBaseListener = operationListener;
        getListAsyncTask = null;

        @SuppressLint("StaticFieldLeak") AsyncTask<Void,Void,List<QuizModel>> listAsyncTask = new AsyncTask<Void, Void, List<QuizModel>>() {
            @Override
            protected List<QuizModel> doInBackground(Void... voids) {
                return myDatabaseHelper.querryForAllQuizModels();
            }

            @Override
            protected void onPostExecute(List<QuizModel> models) {
                super.onPostExecute(models);
                if(readDataBaseListener!=null) readDataBaseListener.onRead(models);
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
        this.getListAsyncTask = listAsyncTask;
        listAsyncTask.execute();
    }

    public void addQuizModel(QuizModel quizModel)
    {
        myDatabaseHelper.createOrUpdate(quizModel);
    }

    public void addQuizModels(List<QuizModel> quizModels)
    {
        for(QuizModel quizModel : quizModels)
        {
            myDatabaseHelper.createOrUpdate(quizModel);
        }
    }

    public void addQuizModelAsync(QuizModel quizModel, OperationListener listener)
    {
        List<QuizModel> quizModels = new ArrayList<>();
        addQuizModelsAsync(quizModels,listener);
    }

    public void addQuizModelsAsync(List<QuizModel> quizModels, OperationListener listener)
    {
        cancelRunningTasks();
        operationListener = listener;
        @SuppressLint("StaticFieldLeak")
        AsyncTask<List<QuizModel>,Integer,Void> addAllItemsTask = new AsyncTask<List<QuizModel>, Integer, Void>() {
            @Override
            protected Void doInBackground(List<QuizModel>... quizModels) {
                if(quizModels==null && quizModels.length==0) return null;

                List<QuizModel> models = quizModels[0];

                for(int i=0; i<models.size();i++)
                {
                    QuizModel quizModel = models.get(i);
                    if(quizModel!=null)
                    {
                        myDatabaseHelper.createOrUpdate(quizModel);
                    }
                    publishProgress((i*100)/models.size());
                }
                return null;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                reportFinish();
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                if(values!=null)
                    reportProgressChange(values[0]);
            }

            @Override
            protected void onCancelled(Void aVoid) {
                super.onCancelled(aVoid);
                reportCancel();
            }

            @Override
            protected void onCancelled() {
                super.onCancelled();
                reportCancel();
            }
        };
        addItemsAsyncTask = addAllItemsTask;
        addAllItemsTask.execute(quizModels);
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

    public interface ReadDataBaseListener extends OperationListener{
        void onRead(List<QuizModel> models);
    }

    public interface OperationListener
    {
        void onFinish();
        void onCanceled();
        void onProgressChange(int percent);
    }
}
