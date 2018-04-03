package pl.iosx.quiz4wp;

import pl.iosx.quiz4wp.ui.base.MvpView;

/**
 * Created by lukaszwroblewski on 02.04.2018.
 */

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);
    void onDetach();
}
