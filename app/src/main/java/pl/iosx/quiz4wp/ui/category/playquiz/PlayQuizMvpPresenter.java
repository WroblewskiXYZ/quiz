package pl.iosx.quiz4wp.ui.category.playquiz;

import pl.iosx.quiz4wp.MvpPresenter;
import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;
import pl.iosx.quiz4wp.ui.category.CategoryMvpView;
import pl.iosx.quiz4wp.ui.category.CategoryPlayQuizCallback;
import pl.iosx.quiz4wp.ui.category.CategoryPresenter;
import pl.iosx.quiz4wp.ui.category.filteredquizlist.FilteredQuizListMvpView;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public interface PlayQuizMvpPresenter<V extends PlayQuizMvpView> extends MvpPresenter<V> {

    void onAnswerButtonClick(int answer);
    void setCallBack(CategoryPlayQuizCallback callBack);
    void setQuizModel(QuizModel quizModel);
}
