package pl.iosx.quiz4wp.ui.category;

import pl.iosx.quiz4wp.ui.base.MvpView;
import pl.iosx.quiz4wp.ui.category.filteredquizlist.FilteredQuizListPresenter;
import pl.iosx.quiz4wp.ui.category.playquiz.PlayQuizMvpPresenter;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public interface CategoryMvpView extends MvpView{

    void onQuizListShow(int screen, FilteredQuizListPresenter filteredQuizListPresenter);
    void onPlayQuizShow(int screen, PlayQuizMvpPresenter playQuizMvpPresenter);
}
