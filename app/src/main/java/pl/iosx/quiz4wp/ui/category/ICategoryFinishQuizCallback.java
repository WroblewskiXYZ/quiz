package pl.iosx.quiz4wp.ui.category;

import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;

/**
 * Created by lukaszwroblewski on 06.04.2018.
 */

public interface ICategoryFinishQuizCallback {
    void onReturnToQuizListCallback();
    void onRetryQuizCallback(QuizModel quizModel);
    void onUnableToShow();
}
