package pl.iosx.quiz4wp.ui.intro;

import pl.iosx.quiz4wp.ui.base.MvpView;

/**
 * Created by lukaszwroblewski on 02.04.2018.
 */

public interface IntroMvpView extends MvpView {
    void openCategoryActivity();
    void updateStatusLabel(String text);
    void changeButtonRetryStatus(boolean visible, boolean enable);
    void updateProgressbarStatus(boolean visible, int percentage);
}
