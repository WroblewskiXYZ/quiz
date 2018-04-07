package pl.iosx.quiz4wp.ui.category.filteredquizlist;

import android.content.Context;

import java.util.List;

import pl.iosx.quiz4wp.R;
import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;
import pl.iosx.quiz4wp.model.services.ApiManager.ApiManager;
import pl.iosx.quiz4wp.ui.base.BasePresenter;
import pl.iosx.quiz4wp.ui.category.ICategoryFilteredListCallback;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public class FilteredQuizListPresenter<V extends IFilteredQuizListMvpView> extends BasePresenter<V>
implements IFilteredQuizListMvpPresenter<V> {

    List<QuizModel> models;
    ICategoryFilteredListCallback filteredListCallback;

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
    public void setCallback(ICategoryFilteredListCallback callback) {
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
                mvpView.onShowLoading();
                contentManager.downloadContentFor(model, new ApiManager.DownloadListListener() {
                    @Override
                    public void onDownload(List<QuizModel> models) {
                        if(models.size()>0)
                        {
                            mvpView.onHideLoading();
                            QuizModel model1 = models.get(0);
                            if(model1.isDownloaded())
                            {
                                filteredListCallback.onQuizPlay(model1);
                                return;
                            }
                        }
                        mvpView.onUnableToDownloadContent(context.getResources().getString(R.string.error_unable_to_provide_content));
                    }

                    @Override
                    public void onFinish() {
                        mvpView.onHideLoading();
                    }

                    @Override
                    public void onCanceled() {
                        mvpView.onHideLoading();
                        mvpView.onUnableToDownloadContent(context.getResources().getString(R.string.error_unable_to_provide_content));
                    }

                    @Override
                    public void onProgressChange(int percent) {

                    }
                });
            }
        }
    }
}
