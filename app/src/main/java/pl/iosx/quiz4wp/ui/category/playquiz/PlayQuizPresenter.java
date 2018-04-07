package pl.iosx.quiz4wp.ui.category.playquiz;

import android.content.Context;

import java.util.List;

import pl.iosx.quiz4wp.R;
import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QAnswer;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QQuestion;
import pl.iosx.quiz4wp.model.data.logic.PlayQuizBoard;
import pl.iosx.quiz4wp.model.services.DbManager.DbManager;
import pl.iosx.quiz4wp.ui.base.BasePresenter;
import pl.iosx.quiz4wp.ui.category.CategoryPlayQuizCallback;
import pl.iosx.quiz4wp.ui.category.filteredquizlist.FilteredQuizListMvpPresenter;
import pl.iosx.quiz4wp.ui.category.filteredquizlist.FilteredQuizListMvpView;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public class PlayQuizPresenter<V extends PlayQuizMvpView> extends BasePresenter<V> implements PlayQuizMvpPresenter<V>,DbManager.OperationListener {

    CategoryPlayQuizCallback categoryPlayQuizCallback;
    QuizModel quizModel;
    PlayQuizBoard playQuizBoard;

    public PlayQuizPresenter(Context context) {
        super(context);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        if(quizModel==null) categoryPlayQuizCallback.onError();
        playQuizBoard = new PlayQuizBoard(quizModel);
        if(playQuizBoard.onStart())
            updateView();
        else
            categoryPlayQuizCallback.onError();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onPause() {
        super.onPause();
        if(quizModel!=null)
            contentManager.save(quizModel, new DbManager.OperationListener() {
                @Override
                public void onFinish() {

                }

                @Override
                public void onCanceled() {

                }

                @Override
                public void onProgressChange(int percent) {

                }
            });
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public boolean isAttached() {
        return super.isAttached();
    }

    @Override
    public V getMvpView() {
        return super.getMvpView();
    }

    @Override
    protected void setUpView() {
        super.setUpView();
    }

    @Override
    protected void startPresenter() {
        super.startPresenter();
    }

    @Override
    public void onAnswerButtonClick(int answer) {
        //mvpView.onEnableAllButtons(false);
        try
        {
            boolean status = playQuizBoard.onResponseAnswer(answer); // add later some animations (correct or not-> disable and change button color for 1s) and then update view
            if(playQuizBoard.onNextQuestion())
                updateView();
            else
                categoryPlayQuizCallback.onQuizFinish(quizModel);
        }
        catch (Exception e)
        {
            categoryPlayQuizCallback.onError();
        }
    }

    @Override
    public void setCallBack(CategoryPlayQuizCallback callBack) {
        this.categoryPlayQuizCallback = callBack;
    }

    @Override
    public void setQuizModel(QuizModel quizModel) {
        this.quizModel = quizModel;
    }

    private void updateView()
    {
        QQuestion qQuestion = playQuizBoard.getCurrentQuestion();
        if(qQuestion!=null && qQuestion.getAnswers()!=null && qQuestion.getAnswers().size()>0)
        {
            mvpView.onProgressUpdate(playQuizBoard.getQuestionSize(),playQuizBoard.getProgress());
            mvpView.onQuestionTitleUpdate(String.format("%s (%d/%d)\nPunkty: %d",context.getString(R.string.question_no),playQuizBoard.getProgress(),playQuizBoard.getQuestionSize(),quizModel.getPercentageScore()));
            boolean imageVisible = qQuestion.getqImage()!=null && qQuestion.getqImage().getUrl()!=null && qQuestion.getqImage().getUrl().length()>0;
            mvpView.onImageContentUpdate(imageVisible,qQuestion.getqImage());
            mvpView.onQuestionContentUpdate(qQuestion.getText());
            for(int i = 1; i<=4; i++)
                mvpView.onAnswerButtonUpdate(i,false,"");
            for(QAnswer answer: qQuestion.getAnswers())
                mvpView.onAnswerButtonUpdate(answer.getOrder(),true,answer.getText());
            mvpView.onEnableAllButtons(true);
        }
        else
        {
            quizModel.setBroken();
            contentManager.save(quizModel, this);
        }

    }

    private void raportBrokenContent()
    {
        categoryPlayQuizCallback.onReturnToQuizListCallback(context.getResources().getString(R.string.quiz_broken));

    }

    @Override
    public void onFinish() {
        raportBrokenContent();
    }

    @Override
    public void onCanceled() {
        raportBrokenContent();
    }

    @Override
    public void onProgressChange(int percent) {

    }
}
