package pl.iosx.quiz4wp.model.data;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import pl.iosx.quiz4wp.model.data.dataUnit.ApiQuizContent;
import pl.iosx.quiz4wp.model.data.dataUnit.ApiQuizItem;
import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;

/**
 * Created by lukaszwroblewski on 30.03.2018.
 */

public class DataConverter {

    public static long getLongFromDateString(String dateStr)
    {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
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

    public static Date getDateFromDateString(String dateStr)
    {
        return new Date(getLongFromDateString(dateStr));
    }
}
