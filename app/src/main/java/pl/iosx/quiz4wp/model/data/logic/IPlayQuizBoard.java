package pl.iosx.quiz4wp.model.data.logic;

import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QAnswer;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QQuestion;

/**
 * Created by lukaszwroblewski on 06.04.2018.
 */

public interface IPlayQuizBoard {

    boolean onStart();
    QQuestion getCurrentQuestion();
    boolean onResponseAnswer(int answer_order);
}
