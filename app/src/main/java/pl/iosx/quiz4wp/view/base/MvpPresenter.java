package pl.iosx.quiz4wp.view.base;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

/**
 * Interface for each presenter (implemented in base presenter)
 */
interface MvpPresenter<V extends MvpView> {
    void onAttach(V mvpView);
    void onDetach();
}
