package pl.iosx.quiz4wp.ui.category.finishquiz;

import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QImage;
import pl.iosx.quiz4wp.ui.base.MvpView;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public interface FinishQuizMvpView extends MvpView {

    void onTitleUpdate(String title);

    void onRateUpdate(String rate);

    void onContentUpdate(String content);
}
