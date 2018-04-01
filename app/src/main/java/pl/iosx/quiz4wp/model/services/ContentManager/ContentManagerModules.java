package pl.iosx.quiz4wp.model.services.ContentManager;

import java.util.List;

import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;
import pl.iosx.quiz4wp.model.services.ApiManager.ApiManager;
import pl.iosx.quiz4wp.model.services.DbManager.DbManager;

/**
 * Created by lukaszwroblewski on 01.04.2018.
 */

public class ContentManagerModules {


    public static void CheckUpdate(final ContentManager contentManager, final CheckBaseListener checkBaseListener, final boolean downloadContents) {
        contentManager.dbManager.getAllQuizModelsAsync(new DbManager.ReadDataBaseListener() {
            @Override
            public void onRead(List<QuizModel> models) {
                contentManager.setQuizModels(models);
                contentManager.apiManager.downloadAllEmptyQuizModelsAsync(new ApiManager.ApiResponseListener() { // download all quiz in async mode
                    @Override
                    public void onReceived(List<QuizModel> models) {
                        ReportContentDownload(contentManager,checkBaseListener,models,downloadContents);
                    }

                    @Override
                    public void onFailure() {
                        ReportFailure(contentManager,checkBaseListener);
                    }
                });
            }

            @Override
            public void onFinish() {

            }

            @Override
            public void onCanceled() {
                ReportFailure(contentManager,checkBaseListener);
            }

            @Override
            public void onProgressChange(int percent) {
                checkBaseListener.onReading(percent);
            }
        });
    }


    public static void ReportFailure(ContentManager contentManager, CheckBaseListener checkBaseListener)
    {
        if(contentManager.hasQuizModels())
            checkBaseListener.onContentReady(false);
        else
            checkBaseListener.onUnableToProvideContent();

        contentManager.setLocked(false);
    }

    public static void ReportContentDownload(final ContentManager contentManager, final CheckBaseListener checkBaseListener, List<QuizModel> downloadedList, boolean downloadAllContentNow)
    {
        if(downloadedList!=null && downloadedList.size()>0)
        {
            if(downloadAllContentNow)
            {
                contentManager.setQuizModels(downloadedList);
                DownloadContentAndSave(contentManager, checkBaseListener,contentManager.getQuizModels());
            }
            else
            {
                contentManager.setQuizModels(downloadedList);
                SaveModelsToDataBase(contentManager,checkBaseListener,contentManager.getQuizModels());
            }
        }
        else
        {
            ReportFailure(contentManager,checkBaseListener);
        }
    }

    public static void DownloadContentAndSave(final ContentManager contentManager, final CheckBaseListener checkBaseListener, final List<QuizModel> modelsToUpdate)
    {
        contentManager.apiManager.downloadContentForQuizList(modelsToUpdate, new ApiManager.DownloadListListener() {
            @Override
            public void onDownload(List<QuizModel> models) {
                ReportContentDownload(contentManager,checkBaseListener,modelsToUpdate,false);
            }

            @Override
            public void onFinish() {

            }

            @Override
            public void onCanceled() {
                ReportFailure(contentManager,checkBaseListener);
            }

            @Override
            public void onProgressChange(int percent) {
                checkBaseListener.onDownloading(percent);
            }
        });
    }

    public static void SaveModelsToDataBase(final ContentManager contentManager, final CheckBaseListener checkBaseListener, List<QuizModel> modelsToSave)
    {
        contentManager.dbManager.addQuizModelsAsync(modelsToSave, new DbManager.OperationListener() {
            @Override
            public void onFinish() {
                checkBaseListener.onContentReady(true);
                contentManager.setLocked(false);
            }

            @Override
            public void onCanceled() {
                ReportFailure(contentManager,checkBaseListener);
            }

            @Override
            public void onProgressChange(int percent) {
                checkBaseListener.onSaving(percent);
            }
        });
    }

    public interface CheckBaseListener
    {
        void onDownloading(int progress);
        void onReading(int progress);
        void onSaving(int progress);
        void onContentReady(boolean download);
        void onUnableToProvideContent();
    }
}
