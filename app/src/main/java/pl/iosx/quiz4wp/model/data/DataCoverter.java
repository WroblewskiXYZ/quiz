package pl.iosx.quiz4wp.model.data;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import pl.iosx.quiz4wp.model.data.apiData.QuizResponse;
import pl.iosx.quiz4wp.model.data.apiData.quiz.QuizItem;
import pl.iosx.quiz4wp.model.data.apiData.quizContent.QuizContent;
import pl.iosx.quiz4wp.model.data.baseData.DbiQuiz;

/**
 * Created by lukaszwroblewski on 30.03.2018.
 */

public class DataCoverter {

    public static DbiQuiz create(QuizItem quizItem)
    {
        DbiQuiz dbiQuiz = new DbiQuiz();
        update(dbiQuiz,quizItem);
        return dbiQuiz;
    }

    public static void update(DbiQuiz dbiQuiz, QuizItem quizItem)
    {
        dbiQuiz.setId(quizItem.getId());
        dbiQuiz.setQuestionsSize(dbiQuiz.getQuestionsSize());
    }

    public static void update(DbiQuiz dbiQuiz, QuizContent quizContent)
    {
        if(dbiQuiz.getId() == quizContent.getId())
        {
            dbiQuiz.setQuestions(quizContent.getQuestions());
        }

    }

    public long getLongFromDateString(String dateStr)
    {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.fff");
        Date date = null;
        long mills = 0;
        try {
            date = (Date)formatter.parse(dateStr);
            mills = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return mills;
    }
}
