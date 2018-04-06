package pl.iosx.quiz4wp.model.data.dataUnit;

import java.util.List;

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
}
