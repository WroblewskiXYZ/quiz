package pl.iosx.quiz4wp.ui.category.playquiz;

import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QImage;
import pl.iosx.quiz4wp.ui.base.IMvpView;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public interface IPlayQuizMvpView extends IMvpView {

    void onQuestionTitleUpdate(String title);

    void onProgressUpdate(int max, int progress);

    void onImageContentUpdate(boolean visible, QImage image);

    void onQuestionContentUpdate(String question_content);

    void onAnswerButtonUpdate(int answer, boolean visible, String label);

    void onEnableAllButtons(boolean enable);

}
