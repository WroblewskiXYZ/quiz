package pl.iosx.quiz4wp.ui.intro;

import android.content.Context;
import android.os.Handler;

import pl.iosx.quiz4wp.R;
import pl.iosx.quiz4wp.model.services.ContentManager.ContentManagerModules;
import pl.iosx.quiz4wp.ui.base.BasePresenter;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public class IntroPresenter<V extends IntroMvpView> extends BasePresenter<V> implements IntroMvpPresenter<V>{

    static final String TAG = "IntroPresenter";
    private static final int GOTO_ACTIVITY_DELAY = 1000;

    public IntroPresenter(Context context)
    {
        super(context);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    @Override
    protected void setUpView() {
        super.setUpView();
        mvpView.changeButtonRetryStatus(false,false);
        mvpView.updateProgressbarStatus(false,0);
    }

    @Override
    protected void startPresenter() {
        super.startPresenter();
        checkContent();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onRetryButtonClick() {
        checkContent();
    }

    private void checkContent()
    {
        if(!contentManager.isLocked())
        {
            contentManager.checkUpdate(new ContentManagerModules.CheckBaseListener() {
                @Override
                public void onDownloading(int progress) {
                    mvpView.updateStatusLabel(context.getString(R.string.downloading_status,progress));
                    mvpView.updateProgressbarStatus(true,progress);
                }

                @Override
                public void onReading(int progress) {
                    mvpView.updateStatusLabel(context.getString(R.string.reading_status,progress));
                    mvpView.updateProgressbarStatus(true,progress);
                }

                @Override
                public void onSaving(int progress) {
                    mvpView.updateStatusLabel(context.getString(R.string.saving_status,progress));
                    mvpView.updateProgressbarStatus(true,progress);
                }

                @Override
                public void onContentReady(boolean download) {
                    mvpView.updateProgressbarStatus(false,0);
                    mvpView.updateStatusLabel(context.getString(R.string.content_goto_category));
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mvpView.openCategoryActivity();
                        }
                    }, GOTO_ACTIVITY_DELAY);
                }

                @Override
                public void onUnableToProvideContent() {
                    mvpView.updateProgressbarStatus(false,0);
                    mvpView.updateStatusLabel(context.getString(R.string.unable_to_download_content));
                    mvpView.changeButtonRetryStatus(true,true);
                }
            },false);
        }
    }


}
