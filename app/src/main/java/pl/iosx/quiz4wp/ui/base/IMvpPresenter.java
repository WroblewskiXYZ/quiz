package pl.iosx.quiz4wp.ui.base;

import pl.iosx.quiz4wp.ui.base.IMvpView;

/**
 * Created by lukaszwroblewski on 02.04.2018.
 */

public interface IMvpPresenter<V extends IMvpView> {

    void onAttach(V mvpView);
    void onDetach();
    void onPause();
    void onResume();
}
