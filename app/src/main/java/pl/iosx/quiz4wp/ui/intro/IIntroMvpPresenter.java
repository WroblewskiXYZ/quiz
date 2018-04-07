package pl.iosx.quiz4wp.ui.intro;

import pl.iosx.quiz4wp.ui.base.IMvpPresenter;

/**
 * Created by lukaszwroblewski on 02.04.2018.
 */

public interface IIntroMvpPresenter<V extends IIntroMvpView> extends IMvpPresenter<V> {

    void onRetryButtonClick();
}
