package pl.iosx.quiz4wp.model.services.DbManager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.android.AndroidDatabaseConnection;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

import java.util.concurrent.Callable;
import io.reactivex.Observable;
import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;
import pl.iosx.quiz4wp.model.data.dataUnit.QuizModelHelper;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QAnswer;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QCategory;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QImage;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QMainPhoto;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QQuestion;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QRate;

/**
 * Created by lukaszwroblewski on 29.03.2018.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DBName";

    private static final int DATABASE_VERSION = 4;

    Dao<QuizModel,Long> daoQuiz;
    Dao<QCategory,Long> daoCategory;
    Dao<QQuestion,Long> daoQuestions;
    Dao<QImage,Long> daoQImages;
    Dao<QMainPhoto,Long> daoMainPhoto;
    Dao<QRate,Long> daoRate;
    Dao<QAnswer,Long> daoAnswer;

    ConnectionSource connectionSource;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        connectionSource = new AndroidConnectionSource(this);
        createDaos();
    }

    public ConnectionSource getConnectionSource() {
        return connectionSource;
    }

   // @Override
   // public void onCreate(SQLiteDatabase database) {
   //     ConnectionSource cs = getConnectionSource();
   // /*
   //      * The method is called by Android database helper's get-database calls when Android detects that we need to
   //      * create or update the database. So we have to use the database argument and save a connection to it on the
   //      * AndroidConnectionSource, otherwise it will go recursive if the subclass calls getConnectionSource().
   //      */
   //     DatabaseConnection conn = cs.getSpecialConnection(null);
   //     boolean clearSpecial = false;
   //     if (conn == null) {
   //         conn = new AndroidDatabaseConnection(database, true, true);
   //         try {
   //             cs.saveSpecialConnection(conn);
   //             clearSpecial = true;
   //         } catch (SQLException e) {
   //             throw new IllegalStateException("Could not save special connection", e);
   //         }
   //     }
   //     try {
   //         this.on
   //     } finally {
   //         if (clearSpecial) {
   //             cs.clearSpecialConnection(conn);
   //         }
   //     }
   //     dropAllTabs();
   //     createTabsIfNotExist();
   // }

    @Override
    public void onCreate(SQLiteDatabase db) {
        isCreating = true;
        currentDB = db;
        dropAllTabs();
        createTabsIfNotExist();
        isCreating = false;
        currentDB = null;
    }

    boolean isCreating = false;
    SQLiteDatabase currentDB = null;

    @Override
    public SQLiteDatabase getWritableDatabase() {
        if(isCreating && currentDB != null){
            return currentDB;
        }
        return super.getWritableDatabase();
    }

    @Override
    public SQLiteDatabase getReadableDatabase() {
        if(isCreating && currentDB != null){
            return currentDB;
        }
        return super.getReadableDatabase();
    }

    @Override
    public void onUpgrade(SQLiteDatabase database,int oldVersion,int newVersion){
        onCreate(database);
    }

    public void clearDataBase()
    {
        onCreate(currentDB);
    }

    private void dropAllTabs() {
        try {
            TableUtils.dropTable(connectionSource, QuizModel.class,true);
            TableUtils.dropTable(connectionSource, QCategory.class,true);
            TableUtils.dropTable(connectionSource, QQuestion.class,true);
            TableUtils.dropTable(connectionSource, QImage.class,true);
            TableUtils.dropTable(connectionSource, QMainPhoto.class,true);
            TableUtils.dropTable(connectionSource, QRate.class,true);
            TableUtils.dropTable(connectionSource, QAnswer.class,true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTabsIfNotExist()
    {
        try {
            TableUtils.createTableIfNotExists(connectionSource, QuizModel.class);
            TableUtils.createTableIfNotExists(connectionSource, QCategory.class);
            TableUtils.createTableIfNotExists(connectionSource, QQuestion.class);
            TableUtils.createTableIfNotExists(connectionSource, QImage.class);
            TableUtils.createTableIfNotExists(connectionSource, QMainPhoto.class);
            TableUtils.createTableIfNotExists(connectionSource, QRate.class);
            TableUtils.createTableIfNotExists(connectionSource, QAnswer.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createDaos()
    {
        try {
            daoQuiz = DaoManager.createDao(connectionSource,QuizModel.class);
            daoCategory = DaoManager.createDao(connectionSource,QCategory.class);
            daoQuestions = DaoManager.createDao(connectionSource,QQuestion.class);
            daoQImages = DaoManager.createDao(connectionSource,QImage.class);
            daoMainPhoto = DaoManager.createDao(connectionSource,QMainPhoto.class);
            daoRate = DaoManager.createDao(connectionSource,QRate.class);
            daoAnswer = DaoManager.createDao(connectionSource,QAnswer.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<QuizModel> queryForAllQuizModels(boolean updatelist)
    {
        List<QuizModel> models = null;
        try {
            models =  daoQuiz.queryForAll();
            if(updatelist) QuizModelHelper.UpdateLists(models);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return models;
    }

    public boolean createOrUpdate(QuizModel quizModel)
    {
        try
        {
            QuizModel newQuizModel = quizModel.getNew(); //new instance, with null object fields
            daoQuiz.createOrUpdate(newQuizModel);
            createOrUpdate(newQuizModel, quizModel.getMainPhoto());
            createOrUpdate(newQuizModel, quizModel.getCategory());

            if(quizModel.isDownloaded())
            {
                if(quizModel.getRates()!=null)
                {
                    daoQuiz.refresh(newQuizModel);
                    for(QRate rate : newQuizModel.getRateForeignCollection()) // delete all answers, before adding new ones
                        daoRate.delete(rate);

                    for (QRate qRate : quizModel.getRates())
                        createOrUpdate(newQuizModel, qRate);
                }
                if(quizModel.getQuestions()!=null)
                {
                    daoQuiz.refresh(newQuizModel);
                    for(QQuestion qQuestion : newQuizModel.getQuestionForeignCollection())
                        daoQuestions.delete(qQuestion);

                    for (QQuestion qQuestion : quizModel.getQuestions()) {
                        createOrUpdate(newQuizModel,qQuestion);
                        daoQuestions.refresh(qQuestion);

                        for(QAnswer answer : qQuestion.getAnswerForeignCollection()) // delete all answers, before adding new ones with generated id
                            daoAnswer.delete(answer);

                        if(qQuestion.getAnswers()!=null)
                        {
                            for (QAnswer answer : qQuestion.getAnswers()) {
                                createOrUpdate(qQuestion,answer);
                            }
                        }
                    }
                }
            }
            daoQuiz.update(newQuizModel);
            return true;
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
    private void createOrUpdate(QuizModel model, QMainPhoto mainPhoto) throws SQLException {
        daoMainPhoto.createOrUpdate(mainPhoto);
        model.setMainPhoto(mainPhoto);
    }

    private void createOrUpdate(QuizModel model, QCategory category) throws SQLException {
        daoCategory.createOrUpdate(category);
        model.setCategory(category);
    }

    private void createOrUpdate(QuizModel model, QRate rate) throws SQLException {
        daoRate.createOrUpdate(rate);
        model.getRateForeignCollection().add(rate);
    }

    private void createOrUpdate(QuizModel model, QQuestion qQuestion) throws SQLException {
        //daoQuestions.createOrUpdate(qQuestion);
        model.getQuestionForeignCollection().add(qQuestion);
    }

    private void createOrUpdate(QQuestion qQuestion, QAnswer answer) throws SQLException {
        //daoAnswer.createOrUpdate(answer);
        qQuestion.getAnswerForeignCollection().add(answer);
    }

    Observable<Boolean> insert(final QuizModel quizModel)
    {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return createOrUpdate(quizModel);
            }
        });
    }

}
