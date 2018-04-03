package pl.iosx.quiz4wp.ui.intro;

import pl.iosx.quiz4wp.MvpPresenter;

/**
 * Created by lukaszwroblewski on 02.04.2018.
 */

public interface IntroMvpPresenter<V extends IntroMvpView> extends MvpPresenter<V> {

    void onRetryButtonClick();
}
