package pl.iosx.quiz4wp.ui.category.finishquiz;

import pl.iosx.quiz4wp.ui.base.IMvpView;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public interface IFinishQuizMvpView extends IMvpView {

    void onTitleUpdate(String title);

    void onRateUpdate(String rate);

    void onContentUpdate(String content);
}
