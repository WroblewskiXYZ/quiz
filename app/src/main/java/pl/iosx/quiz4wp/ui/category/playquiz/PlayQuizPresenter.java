package pl.iosx.quiz4wp.ui.category.playquiz;

import android.content.Context;

import java.util.List;

import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;
import pl.iosx.quiz4wp.ui.base.BasePresenter;
import pl.iosx.quiz4wp.ui.category.filteredquizlist.FilteredQuizListMvpPresenter;
import pl.iosx.quiz4wp.ui.category.filteredquizlist.FilteredQuizListMvpView;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public class PlayQuizPresenter<V extends PlayQuizMvpView> extends BasePresenter<V>
implements PlayQuizMvpPresenter<V>{

    public PlayQuizPresenter(Context context) {
        super(context);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
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
    public void onViewPrepared() {
        List<QuizModel> models = contentManager.getQuizModels();
        if(models!=null)
            mvpView.onItemsUpdate(models);
    }
}
