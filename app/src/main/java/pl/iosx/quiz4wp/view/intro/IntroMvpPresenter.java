package pl.iosx.quiz4wp.view.intro;

import pl.iosx.quiz4wp.MvpPresenter;
import pl.iosx.quiz4wp.view.base.MvpView;

/**
 * Created by lukaszwroblewski on 02.04.2018.
 */

public interface IntroMvpPresenter<V extends IntroMvpView> extends MvpPresenter<V> {

    void onRetryButtonClick();
}
