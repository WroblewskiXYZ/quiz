package pl.iosx.quiz4wp.ui.category.finishquiz;

import pl.iosx.quiz4wp.MvpPresenter;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public interface FinishQuizMvpPresenter<V extends FinishQuizMvpView> extends MvpPresenter<V> {

    void onQuizRepeatButtonClick();
    void onReturnToQuizListButtonClick();
}
