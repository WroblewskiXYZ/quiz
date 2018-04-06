package pl.iosx.quiz4wp.model.data.logic;

import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QQuestion;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QRate;

/**
 * Created by lukaszwroblewski on 06.04.2018.
 */

public interface IPlayQuizBoardCallback {
    void onError();
    void onQuizFinish(QRate rate, int score);
}
