package pl.iosx.quiz4wp.ui.base;

import android.content.Context;

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

    protected void startPresenter() {

    }
}
