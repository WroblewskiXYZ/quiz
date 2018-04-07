package pl.iosx.quiz4wp.ui.intro;

import pl.iosx.quiz4wp.ui.base.IMvpView;

/**
 * Created by lukaszwroblewski on 02.04.2018.
 */

public interface IIntroMvpView extends IMvpView {
    void openCategoryActivity();
    void updateStatusLabel(String text);
    void changeButtonRetryStatus(boolean visible, boolean enable);
    void updateProgressbarStatus(boolean visible, int percentage);
}
