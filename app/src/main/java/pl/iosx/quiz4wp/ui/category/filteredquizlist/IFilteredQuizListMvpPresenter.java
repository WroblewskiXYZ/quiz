package pl.iosx.quiz4wp.ui.category.filteredquizlist;

import pl.iosx.quiz4wp.ui.base.IMvpPresenter;
import pl.iosx.quiz4wp.ui.category.ICategoryFilteredListCallback;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public interface IFilteredQuizListMvpPresenter<V extends IFilteredQuizListMvpView> extends IMvpPresenter<V> {
    void onViewPrepared();
    void setCallback(ICategoryFilteredListCallback callback);
}
