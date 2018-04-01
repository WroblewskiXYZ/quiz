package pl.iosx.quiz4wp.model.services.DbManager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

import java.util.concurrent.Callable;
import io.reactivex.Observable;
import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;
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

    private static final int DATABASE_VERSION = 2;

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

    @Override
    public void onCreate(SQLiteDatabase database) {
        dropAllTabs();
        createTabsIfNotExist();
    }

    @Override
    public void onUpgrade(SQLiteDatabase database,int oldVersion,int newVersion){
        onCreate(database);
    }

    public void clearDataBase()
    {
        this.onCreate(getWritableDatabase());
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

    public List<QuizModel> querryForAllQuizModels()
    {
        List<QuizModel> models = null;
        try {
           models =  daoQuiz.queryForAll();
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

            daoQuiz.update(newQuizModel);

            if(quizModel.isDownloaded())
            {
                if(quizModel.getRates()!=null)
                {
                    daoQuiz.refresh(newQuizModel);
                    for (QRate qRate : quizModel.getRates())
                        createOrUpdate(newQuizModel, qRate);
                }
                if(quizModel.getQuestions()!=null)
                {
                    for (QQuestion qQuestion : quizModel.getQuestions()) {
                        createOrUpdate(newQuizModel,qQuestion);
                        daoQuestions.refresh(qQuestion);
                        if(qQuestion.getAnswers()!=null)
                        {
                            for (QAnswer answer : qQuestion.getAnswers()) {
                                createOrUpdate(qQuestion,answer);
                            }
                        }
                    }
                }
            }
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
