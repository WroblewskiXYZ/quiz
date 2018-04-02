package pl.iosx.quiz4wp.view;

import android.support.annotation.StringRes;

/**
 * Created by lukaszwroblewski on 02.04.2018.
 */

public interface MvpView {

    void showLoading();

    void hideLoading();

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    void openStartActivity();

    boolean isNetworkConnected();
}
