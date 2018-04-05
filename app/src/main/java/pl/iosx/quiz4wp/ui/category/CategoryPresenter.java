package pl.iosx.quiz4wp.ui.category;

import android.content.Context;

import javax.inject.Inject;

import pl.iosx.quiz4wp.MvpPresenter;
import pl.iosx.quiz4wp.QuizApp;
import pl.iosx.quiz4wp.model.services.ContentManager.ContentManager;
import pl.iosx.quiz4wp.ui.base.BasePresenter;
import pl.iosx.quiz4wp.ui.category.filteredquizlist.FilteredQuizListPresenter;
import pl.iosx.quiz4wp.ui.category.playquiz.PlayQuizMvpPresenter;
import pl.iosx.quiz4wp.ui.category.playquiz.PlayQuizPresenter;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public class CategoryPresenter<V extends CategoryMvpView> extends BasePresenter<V> implements CategoryMvpPresenter<V>{

    FilteredQuizListPresenter listPresenter;
    PlayQuizMvpPresenter playQuizMvpPresenter;

    public CategoryPresenter(Context context) {
        super(context);
        listPresenter = new FilteredQuizListPresenter(context);
        playQuizMvpPresenter = new PlayQuizPresenter(context);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    @Override
    protected void startPresenter() {
        super.startPresenter();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public boolean isAttached() {
        return super.isAttached();
    }

    @Override
    public V getMvpView() {
        return super.getMvpView();
    }

    @Override
    protected void setUpView() {
        super.setUpView();

    }
}
