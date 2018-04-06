package pl.iosx.quiz4wp.ui.category.finishquiz;

import pl.iosx.quiz4wp.MvpPresenter;
import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;
import pl.iosx.quiz4wp.ui.category.CategoryFinishQuizCallback;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public interface FinishQuizMvpPresenter<V extends FinishQuizMvpView> extends MvpPresenter<V> {

    void onQuizRepeatButtonClick();
    void onReturnToQuizListButtonClick();
    void setCallback(CategoryFinishQuizCallback callback);
    void setFinishedQuiz(QuizModel finishedQuiz);

}
