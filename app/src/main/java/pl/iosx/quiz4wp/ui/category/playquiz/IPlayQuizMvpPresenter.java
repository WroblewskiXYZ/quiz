package pl.iosx.quiz4wp.ui.category.playquiz;

import pl.iosx.quiz4wp.ui.base.IMvpPresenter;
import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;
import pl.iosx.quiz4wp.ui.category.ICategoryPlayQuizCallback;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public interface IPlayQuizMvpPresenter<V extends IPlayQuizMvpView> extends IMvpPresenter<V> {

    void onAnswerButtonClick(int answer);
    void setCallBack(ICategoryPlayQuizCallback callBack);
    void setQuizModel(QuizModel quizModel);
}
