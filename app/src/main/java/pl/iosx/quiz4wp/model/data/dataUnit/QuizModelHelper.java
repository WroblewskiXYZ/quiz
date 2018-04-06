package pl.iosx.quiz4wp.model.data.dataUnit;

import java.util.List;

import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QRate;

/**
 * Created by lukaszwroblewski on 06.04.2018.
 */

public class QuizModelHelper {

    public static void UpdateLists(List<QuizModel> models)
    {
        for(QuizModel model : models)
        {
            model.updateLists();
        }
    }

    public static QRate GetRate(QuizModel model)
    {
        if(model.isDone())
        {
            int percentageScore = model.getPercentageScore();
            if(model.getRates()!=null)
            {
                for(QRate rate : model.getRates())
                {
                    if(percentageScore>=rate.getFrom() && percentageScore<=rate.getTo())
                    {
                        return rate;
                    }
                }
            }
        }
        return null;
    }
}
