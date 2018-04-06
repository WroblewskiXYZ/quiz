package pl.iosx.quiz4wp.model.data.logic;

import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QAnswer;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QQuestion;

/**
 * Created by lukaszwroblewski on 06.04.2018.
 */

public class PlayQuizBoard implements IPlayQuizBoard {

    IPlayQuizBoardCallback callback;
    QuizModel quizModel;
    QQuestion currentQuestion;
    int questionCouter =0;

    public PlayQuizBoard(QuizModel quizModel) {
        this.quizModel = quizModel;
    }

    public void setCallback(IPlayQuizBoardCallback callback) {
        this.callback = callback;
    }

    @Override
    public boolean onStart() {
        if(quizModel!=null
                && quizModel.getQuestions()!=null
                && quizModel.getQuestions().size()>0
                && quizModel.getQuestionsSize() == quizModel.getQuestions().size())
        {
            if(quizModel.isDone()) quizModel.resetScore();
            questionCouter = quizModel.getQuestionsDone();
            pickNextQuestion();

            return currentQuestion!=null;
        }
        return false;
    }

    @Override
    public QQuestion getCurrentQuestion() {
        return currentQuestion;
    }

    @Override
    public boolean onResponseAnswer(int answer_order) {
        boolean status = false;
        if(currentQuestion!=null && currentQuestion.getAnswers()!=null)
        {
            for(QAnswer answer : currentQuestion.getAnswers())
            {
                if(answer.getOrder() == answer_order)
                {
                    status = answer.isCorrect();
                    quizModel.onQuestionDone(status);
                    break;
                }
            }
        }
        return status;
    }

    public boolean onNextQuestion()
    {
        if (quizModel!=null && quizModel.getQuestions()!=null && (questionCouter+1 < quizModel.getQuestions().size())){
            questionCouter++;
            pickNextQuestion();
            return true;
        }
        return false;
    }

    private void pickNextQuestion()
    {
        currentQuestion = null;
        if(questionCouter<quizModel.getQuestionsSize())
            currentQuestion = quizModel.getQuestions().get(questionCouter);
    }

    public int getProgress()
    {
        if(quizModel!=null && quizModel.getQuestions()!=null)
        {
            return questionCouter;
        }
        return 0;
    }

    public int getQuestionSize()
    {
        if(quizModel!=null && quizModel.getQuestions()!=null)
        {
            return quizModel.getQuestions().size();
        }
        return 0;
    }

}
