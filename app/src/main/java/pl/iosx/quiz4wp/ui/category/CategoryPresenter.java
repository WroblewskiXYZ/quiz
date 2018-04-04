package pl.iosx.quiz4wp.ui.category;

import android.content.Context;

import javax.inject.Inject;

import pl.iosx.quiz4wp.MvpPresenter;
import pl.iosx.quiz4wp.QuizApp;
import pl.iosx.quiz4wp.model.services.ContentManager.ContentManager;
import pl.iosx.quiz4wp.ui.base.BasePresenter;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public class CategoryPresenter<V extends CategoryMvpView> extends BasePresenter<V> implements CategoryMvpPresenter<V>{


    public CategoryPresenter(Context context) {
        super(context);

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
