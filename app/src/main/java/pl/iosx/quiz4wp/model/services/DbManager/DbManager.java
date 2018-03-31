package pl.iosx.quiz4wp.model.services.DbManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

import com.j256.ormlite.support.ConnectionSource;

import java.util.List;

import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;

/**
 * Created by lukaszwroblewski on 29.03.2018.
 */

public class DbManager {

    private Context context;
    MyDatabaseHelper myDatabaseHelper;
    ConnectionSource connectionSource;
    OperationListener operationListener;

    public DbManager(Context context)
    {
        this.context = context;
        this.myDatabaseHelper = new MyDatabaseHelper(context);
    }

    public void cancel()
    {
        if(clearDataBasetask.getStatus()== AsyncTask.Status.RUNNING)
        {
            clearDataBasetask.cancel(true);
            reportCancel();
        }
    }

    public void clearDataBase()
    {
        clearDataBasetask.execute();
    }

    public void clearDataBaseAsync(OperationListener listener)
    {
        cancel();
        operationListener = listener;
        clearDataBasetask.execute();
    }

    public List<QuizModel> getAllQuizModels()
    {
        return myDatabaseHelper.querryForAllQuizModels();
    }

    public void addQuizModel(QuizModel quizModel)
    {
        cancel();
        myDatabaseHelper.createOrUpdate(quizModel);
    }

    public void addQuizModels(List<QuizModel> quizModels)
    {
        cancel();
        for(QuizModel quizModel : quizModels)
        {
            myDatabaseHelper.createOrUpdate(quizModel);
        }
    }

    public void addQuizModelAsync(QuizModel quizModel, OperationListener listener)
    {
        cancel();
        operationListener = listener;
        addAllItemsTask.execute(quizModel);
    }

    public void addQuizModelsAsync(List<QuizModel> quizModels, OperationListener listener)
    {
        cancel();
        operationListener = listener;
        addAllItemsTask.execute((QuizModel[])quizModels.toArray());
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

    @SuppressLint("StaticFieldLeak")
    AsyncTask<Void,Void,Void> clearDataBasetask = new AsyncTask<Void, Void, Void>() {
        @Override
        protected Void doInBackground(Void... voids) {
            myDatabaseHelper.clearDataBase();
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

    @SuppressLint("StaticFieldLeak")
    AsyncTask<QuizModel,Integer,Void> addAllItemsTask = new AsyncTask<QuizModel, Integer, Void>() {
        @Override
        protected Void doInBackground(QuizModel... quizModels) {
            if(quizModels==null) return null;
            for(int i=0; i<quizModels.length;i++)
            {
               QuizModel quizModel = quizModels[i];
               if(quizModel!=null)
               {
                   myDatabaseHelper.createOrUpdate(quizModel);
               }
               publishProgress(quizModels.length/i);
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

    public interface OperationListener
    {
        void onFinish();
        void onCanceled();
        void onProgressChange(int percent);
    }
}
