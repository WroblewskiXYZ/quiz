package pl.iosx.quiz4wp.ui.category.finishquiz;

import android.content.Context;

import pl.iosx.quiz4wp.ui.base.BasePresenter;
import pl.iosx.quiz4wp.ui.category.CategoryFinishQuizCallback;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public class FinishQuizPresenter<V extends FinishQuizMvpView> extends BasePresenter<V> implements FinishQuizMvpPresenter<V> {

    CategoryFinishQuizCallback categoryFinishQuizCallback;

    public FinishQuizPresenter(Context context) {
        super(context);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
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

    @Override
    protected void startPresenter() {
        super.startPresenter();
    }

    @Override
    public void onQuizRepeatButtonClick() {

    }

    @Override
    public void onReturnToQuizListButtonClick() {

    }

    @Override
    public void setCallback(CategoryFinishQuizCallback callback) {
        this.categoryFinishQuizCallback = callback;
    }
}
