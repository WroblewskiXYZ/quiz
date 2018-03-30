package pl.iosx.quiz4wp.model.data.baseData;

import android.support.test.InstrumentationRegistry;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import org.junit.Test;

import java.sql.Date;
import java.sql.SQLException;

import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QAnswer;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QCategory;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QMainPhoto;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QImage;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QQuestion;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QRate;
import pl.iosx.quiz4wp.model.services.DbManager.DbManager;

/**
 * Created by lukaszwroblewski on 29.03.2018.
 */
public class DataBaseQuizModelTest {

    @Test
    public void shouldAddQuizTest() throws SQLException {
        DbManager dbManager = new DbManager(InstrumentationRegistry.getTargetContext());

        ConnectionSource connectionSource = dbManager.getConnectionSource();
        TableUtils.dropTable(connectionSource, QuizModel.class,true);
        TableUtils.dropTable(connectionSource, QCategory.class,true);
        TableUtils.dropTable(connectionSource, QQuestion.class,true);
        TableUtils.dropTable(connectionSource, QImage.class,true);
        TableUtils.dropTable(connectionSource, QMainPhoto.class,true);
        TableUtils.dropTable(connectionSource, QRate.class,true);
        TableUtils.dropTable(connectionSource, QAnswer.class,true);

        TableUtils.createTableIfNotExists(connectionSource, QuizModel.class);
        TableUtils.createTableIfNotExists(connectionSource, QCategory.class);
        TableUtils.createTableIfNotExists(connectionSource, QQuestion.class);
        TableUtils.createTableIfNotExists(connectionSource, QImage.class);
        TableUtils.createTableIfNotExists(connectionSource, QMainPhoto.class);
        TableUtils.createTableIfNotExists(connectionSource, QRate.class);
        TableUtils.createTableIfNotExists(connectionSource, QAnswer.class);


        Dao<QuizModel,Long> daoQuiz = DaoManager.createDao(connectionSource,QuizModel.class);
        Dao<QCategory,Long> daoCategory = DaoManager.createDao(connectionSource,QCategory.class);
        Dao<QQuestion,Long> daoQuestions = DaoManager.createDao(connectionSource,QQuestion.class);
        Dao<QImage,Long> daoQImages = DaoManager.createDao(connectionSource,QImage.class);
        Dao<QMainPhoto,Long> daoMainPhoto = DaoManager.createDao(connectionSource,QMainPhoto.class);
        Dao<QRate,Long> daoRate = DaoManager.createDao(connectionSource,QRate.class);
        Dao<QAnswer,Long> daoAnswer = DaoManager.createDao(connectionSource,QAnswer.class);


        QuizModel quizModel = new QuizModel(12,12,new Date(1522164993000l),"tytułLL", "KNOWLEDGE", "jakiś content",true,new QCategory(4,"aaaa"),2.33,34,false);
        QCategory qCategory = new QCategory(1,"kategoria 1");
        daoCategory.createIfNotExists(qCategory);
        quizModel.setCategory(qCategory);



        QQuestion question1 = new QQuestion();
        question1.setText("1 pytanie 1");
        QAnswer qAnswer = new QAnswer();
        qAnswer.setText("1 odpowiedz 1");
        daoAnswer.createIfNotExists(qAnswer);
        QAnswer qAnswer2 = new QAnswer();
        qAnswer2.setText("1 odpowiedz 2");
        daoAnswer.createIfNotExists(qAnswer2);
        daoQuestions.createIfNotExists(question1);
        daoQuestions.refresh(question1);
        question1.getAnswerForeignCollection().add(qAnswer);
        question1.getAnswerForeignCollection().add(qAnswer2);


        QQuestion question2 = new QQuestion();
        question2.setText("2 pytanie 1");
        QAnswer qAnswer3 = new QAnswer();
        qAnswer3.setText("2 odpowiedz 3");
        daoAnswer.createIfNotExists(qAnswer3);
        QAnswer qAnswer4 = new QAnswer();
        qAnswer4.setText("2 odpowiedz 4");
        daoAnswer.createIfNotExists(qAnswer4);
        //question2.;
        question2.getAnswerForeignCollection().add(qAnswer3);
        question2.getAnswerForeignCollection().add(qAnswer4);
        daoQuestions.createIfNotExists(question2);

        quizModel.getQuestionForeignCollection().add(question1);
        quizModel.getQuestionForeignCollection().add(question2);
        daoQuiz.createIfNotExists(quizModel);

        QuizModel quizModel1 = daoQuiz.queryForId(0l);

        //QAnswer qAnswer8 = new QAnswer(1,"odpowiedz",true);
        //QAnswer answer = (QAnswer) qAnswer8;

    }

}