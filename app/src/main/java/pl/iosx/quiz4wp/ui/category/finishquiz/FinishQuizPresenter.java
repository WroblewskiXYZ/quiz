package pl.iosx.quiz4wp.ui.category.finishquiz;

import android.content.Context;

import pl.iosx.quiz4wp.R;
import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;
import pl.iosx.quiz4wp.model.data.dataUnit.QuizModelHelper;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QRate;
import pl.iosx.quiz4wp.model.services.DbManager.DbManager;
import pl.iosx.quiz4wp.ui.base.BasePresenter;
import pl.iosx.quiz4wp.ui.category.ICategoryFinishQuizCallback;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public class FinishQuizPresenter<V extends IFinishQuizMvpView> extends BasePresenter<V> implements IFinishQuizMvpPresenter<V>,DbManager.OperationListener {

    ICategoryFinishQuizCallback categoryFinishQuizCallback;
    private QuizModel finishedQuiz;

    public FinishQuizPresenter(Context context) {
        super(context);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        updateView();
        if(finishedQuiz!=null) contentManager.save(finishedQuiz, this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
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
    public void onQuizRepeatButtonClick() {
        categoryFinishQuizCallback.onRetryQuizCallback(finishedQuiz);
    }

    @Override
    public void onReturnToQuizListButtonClick() {
        categoryFinishQuizCallback.onReturnToQuizListCallback();
    }

    @Override
    public void setCallback(ICategoryFinishQuizCallback callback) {
        this.categoryFinishQuizCallback = callback;
    }

    @Override
    public void setFinishedQuiz(QuizModel finishedQuiz) {
        this.finishedQuiz = finishedQuiz;
    }

    private void updateView()
    {
        if(finishedQuiz!=null)
        {
            QRate rate = QuizModelHelper.GetRate(finishedQuiz);
            if(rate!=null)
                mvpView.onRateUpdate(rate.getContent());
            else
                mvpView.onRateUpdate(context.getString(R.string.rate_default));
            mvpView.onContentUpdate(String.format(context.getString(R.string.finishquiz_content),finishedQuiz.getPercentageScore()));
        }
    }

    @Override
    public void onFinish() {

    }

    @Override
    public void onCanceled() {

    }

    @Override
    public void onProgressChange(int percent) {

    }
}
