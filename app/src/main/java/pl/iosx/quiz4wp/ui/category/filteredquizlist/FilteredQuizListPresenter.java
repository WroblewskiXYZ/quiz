package pl.iosx.quiz4wp.ui.category.filteredquizlist;

import android.content.Context;

import pl.iosx.quiz4wp.ui.base.BasePresenter;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public class FilteredQuizListPresenter<V extends FilteredQuizListMvpView> extends BasePresenter<V>
implements FilteredQuizListMvpPresenter<V>{

    public FilteredQuizListPresenter(Context context) {
        super(context);
    }
}
