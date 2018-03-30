package pl.iosx.quiz4wp.model.data.baseData;

import android.support.test.InstrumentationRegistry;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import org.junit.Test;

import java.sql.Date;
import java.sql.SQLException;

import pl.iosx.quiz4wp.model.data.runTimeData.QAnswer;
import pl.iosx.quiz4wp.model.services.DbManager.DbManager;

/**
 * Created by lukaszwroblewski on 29.03.2018.
 */
public class DataBaseDbiQuizTest {

    @Test
    public void shouldAddQuizTest() throws SQLException {
        DbManager dbManager = new DbManager(InstrumentationRegistry.getTargetContext());

        ConnectionSource connectionSource = dbManager.getConnectionSource();
        TableUtils.dropTable(connectionSource, DbiQuiz.class,true);
        TableUtils.dropTable(connectionSource, DbiCategory.class,true);
        TableUtils.dropTable(connectionSource, DbiQuestion.class,true);
        TableUtils.dropTable(connectionSource, DbiQImage.class,true);
        TableUtils.dropTable(connectionSource, DbiMainPhoto.class,true);
        TableUtils.dropTable(connectionSource, DbiRate.class,true);
        TableUtils.dropTable(connectionSource, DbiAnswer.class,true);

        TableUtils.createTableIfNotExists(connectionSource, DbiQuiz.class);
        TableUtils.createTableIfNotExists(connectionSource, DbiCategory.class);
        TableUtils.createTableIfNotExists(connectionSource, DbiQuestion.class);
        TableUtils.createTableIfNotExists(connectionSource, DbiQImage.class);
        TableUtils.createTableIfNotExists(connectionSource, DbiMainPhoto.class);
        TableUtils.createTableIfNotExists(connectionSource, DbiRate.class);
        TableUtils.createTableIfNotExists(connectionSource, DbiAnswer.class);


        Dao<DbiQuiz,Long> daoQuiz = DaoManager.createDao(connectionSource,DbiQuiz.class);
        Dao<DbiCategory,Long> daoCategory = DaoManager.createDao(connectionSource,DbiCategory.class);
        Dao<DbiQuestion,Long> daoQuestions = DaoManager.createDao(connectionSource,DbiQuestion.class);
        Dao<DbiQImage,Long> daoQImages = DaoManager.createDao(connectionSource,DbiQImage.class);
        Dao<DbiMainPhoto,Long> daoMainPhoto = DaoManager.createDao(connectionSource,DbiMainPhoto.class);
        Dao<DbiRate,Long> daoRate = DaoManager.createDao(connectionSource,DbiRate.class);
        Dao<DbiAnswer,Long> daoAnswer = DaoManager.createDao(connectionSource,DbiAnswer.class);


        DbiQuiz dbiQuiz = new DbiQuiz(12,12,new Date(1522164993000l),"tytułLL", "KNOWLEDGE", "jakiś content",true,new DbiCategory(4,"aaaa"),2.33,34,false);
        DbiCategory dbiCategory = new DbiCategory(1,"kategoria 1");
        daoCategory.createIfNotExists(dbiCategory);
        dbiQuiz.setCategory(dbiCategory);



        DbiQuestion question1 = new DbiQuestion();
        question1.setText("1 pytanie 1");
        DbiAnswer dbiAnswer = new DbiAnswer();
        dbiAnswer.setText("1 odpowiedz 1");
        daoAnswer.createIfNotExists(dbiAnswer);
        DbiAnswer dbiAnswer2 = new DbiAnswer();
        dbiAnswer2.setText("1 odpowiedz 2");
        daoAnswer.createIfNotExists(dbiAnswer2);
        daoQuestions.createIfNotExists(question1);
        daoQuestions.refresh(question1);
        question1.getAnswerForeignCollection().add(dbiAnswer);
        question1.getAnswerForeignCollection().add(dbiAnswer2);


        DbiQuestion question2 = new DbiQuestion();
        question2.setText("2 pytanie 1");
        DbiAnswer dbiAnswer3 = new DbiAnswer();
        dbiAnswer3.setText("2 odpowiedz 3");
        daoAnswer.createIfNotExists(dbiAnswer3);
        DbiAnswer dbiAnswer4 = new DbiAnswer();
        dbiAnswer4.setText("2 odpowiedz 4");
        daoAnswer.createIfNotExists(dbiAnswer4);
        //question2.;
        question2.getAnswerForeignCollection().add(dbiAnswer3);
        question2.getAnswerForeignCollection().add(dbiAnswer4);
        daoQuestions.createIfNotExists(question2);

        dbiQuiz.getQuestionForeignCollection().add(question1);
        dbiQuiz.getQuestionForeignCollection().add(question2);
        daoQuiz.createIfNotExists(dbiQuiz);

        DbiQuiz dbiQuiz1 = daoQuiz.queryForId(0l);

        DbiAnswer dbiAnswer8 = new DbiAnswer(1,"odpowiedz",true);
        QAnswer answer = (QAnswer)dbiAnswer8;

    }

}