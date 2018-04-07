package pl.iosx.quiz4wp.ui.category.finishquiz;

import pl.iosx.quiz4wp.ui.base.IMvpPresenter;
import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;
import pl.iosx.quiz4wp.ui.category.ICategoryFinishQuizCallback;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public interface IFinishQuizMvpPresenter<V extends IFinishQuizMvpView> extends IMvpPresenter<V> {

    void onQuizRepeatButtonClick();
    void onReturnToQuizListButtonClick();
    void setCallback(ICategoryFinishQuizCallback callback);
    void setFinishedQuiz(QuizModel finishedQuiz);

}
