package pl.iosx.quiz4wp.model.data.dataUnit;

import java.util.ArrayList;
import java.util.HashMap;
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

    public static List<QuizModel> ReturnNewQuizzes(List<QuizModel> currentModels, List<QuizModel> newModels)
    {
        List<QuizModel> resultModels = new ArrayList<>();
        if(newModels==null) return resultModels;
        if(currentModels==null) return newModels;

        HashMap<Long,QuizModel> hashCurrentModels = GetHashMap(currentModels);
        resultModels = GetNewModels(newModels,hashCurrentModels);
        return resultModels;
    }

    private static HashMap<Long,QuizModel> GetHashMap(List<QuizModel> models)
    {
        HashMap<Long,QuizModel> hashNewModels = new HashMap<>();
        for(QuizModel model : models)
            hashNewModels.put(model.getId(),model);
        return hashNewModels;
    }

    private static List<QuizModel> GetNewModels(List<QuizModel> newModels, HashMap<Long,QuizModel> hashCurrentModels)
    {
        List<QuizModel> resultModels = new ArrayList<>();
        for(QuizModel newModel : newModels) {
            QuizModel currentModel = hashCurrentModels.get(newModel.getId());
            if(currentModel==null
                    || currentModel.getCreated()==null
                    || (newModel!=null && newModel.getCreated()!=null && newModel.getCreated().compareTo(currentModel.getCreated())>0))
                resultModels.add(newModel);
        }
        return resultModels;
    }

}
