package pl.iosx.quiz4wp.ui.category.playquiz;

import pl.iosx.quiz4wp.MvpPresenter;
import pl.iosx.quiz4wp.ui.category.filteredquizlist.FilteredQuizListMvpView;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public interface PlayQuizMvpPresenter<V extends PlayQuizMvpView> extends MvpPresenter<V> {
    void onViewPrepared();
}
