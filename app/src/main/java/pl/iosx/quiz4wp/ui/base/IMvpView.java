package pl.iosx.quiz4wp.ui.base;

import android.support.annotation.StringRes;

/**
 * Created by lukaszwroblewski on 02.04.2018.
 */

public interface IMvpView {

    void showLoading();

    void hideLoading();

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    void openBaseActivity();

    boolean isNetworkConnected();
}
