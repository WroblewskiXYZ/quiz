package pl.iosx.quiz4wp.ui.category.filteredquizlist;

import pl.iosx.quiz4wp.MvpPresenter;
import pl.iosx.quiz4wp.ui.category.CategoryFilteredListCallback;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public interface FilteredQuizListMvpPresenter<V extends FilteredQuizListMvpView> extends MvpPresenter<V> {
    void onViewPrepared();
    void setCallback(CategoryFilteredListCallback callback);
}
