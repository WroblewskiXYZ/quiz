package pl.iosx.quiz4wp.ui.category.filteredquizlist;

import android.content.Context;

import java.util.List;

import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;
import pl.iosx.quiz4wp.model.services.ContentManager.ContentManagerModules;
import pl.iosx.quiz4wp.ui.base.BasePresenter;
import pl.iosx.quiz4wp.ui.category.CategoryFilteredListCallback;
import pl.iosx.quiz4wp.ui.category.playquiz.PlayQuizMvpPresenter;
import pl.iosx.quiz4wp.ui.category.playquiz.PlayQuizPresenter;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public class FilteredQuizListPresenter<V extends FilteredQuizListMvpView> extends BasePresenter<V>
implements FilteredQuizListMvpPresenter<V>{

    List<QuizModel> models;
    CategoryFilteredListCallback filteredListCallback;

    public FilteredQuizListPresenter(Context context) {
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
        models = contentManager.getQuizModels();
        if(models!=null)
            mvpView.onItemsUpdate(models);
    }

    @Override
    public void setCallback(CategoryFilteredListCallback callback) {
        this.filteredListCallback = callback;
    }

    public void onQuizItemClicked(int position, long id) {
        if(models!=null && models.size()>position)
        {
            QuizModel model = models.get(position);
            if(model.isDownloaded())
            {
                filteredListCallback.onQuizPlay(model);
            }
            else
            {
                
            }
        }
    }
}
