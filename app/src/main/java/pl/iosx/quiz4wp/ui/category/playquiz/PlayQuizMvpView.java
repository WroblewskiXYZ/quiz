package pl.iosx.quiz4wp.ui.category.playquiz;

import java.util.List;

import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;
import pl.iosx.quiz4wp.ui.base.MvpView;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public interface PlayQuizMvpView extends MvpView {

    void onItemsUpdate(List<QuizModel> quizModels);
}
