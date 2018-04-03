package pl.iosx.quiz4wp.view.base;

import android.content.Context;

import javax.inject.Inject;

import pl.iosx.quiz4wp.QuizApp;
import pl.iosx.quiz4wp.model.services.ContentManager.ContentManager;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public class BasePresenter<V extends MvpView> extends Presenter implements MvpPresenter<V> {

    protected Context context;

    protected V mvpView;

    public BasePresenter(Context context) {
        super();
        this.context = context;
    }

    @Override
    public void onAttach(V mvpView) {
        this.mvpView = mvpView;
        setUpView();
        startPresenter();
    }

    protected void startPresenter() {

    }

    @Override
    public void onDetach() {
        mvpView = null;
    }

    public boolean isAttached()
    {
        return mvpView!=null;
    }


    public V getMvpView() {
        return mvpView;
    }

    protected void setUpView()
    {

    }
}
