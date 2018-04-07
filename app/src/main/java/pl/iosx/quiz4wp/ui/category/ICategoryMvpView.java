package pl.iosx.quiz4wp.ui.category;

import pl.iosx.quiz4wp.ui.base.IMvpView;
import pl.iosx.quiz4wp.ui.category.filteredquizlist.FilteredQuizListPresenter;
import pl.iosx.quiz4wp.ui.category.finishquiz.FinishQuizPresenter;
import pl.iosx.quiz4wp.ui.category.playquiz.IPlayQuizMvpPresenter;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public interface ICategoryMvpView extends IMvpView {

    void onQuizListShow(int screen, FilteredQuizListPresenter filteredQuizListPresenter);
    void onPlayQuizShow(int screen, IPlayQuizMvpPresenter playQuizMvpPresenter);
    void onFinishQuizShow(int screen, FinishQuizPresenter finishQuizPresenter);
    void onErrorMessage(String message);
}
