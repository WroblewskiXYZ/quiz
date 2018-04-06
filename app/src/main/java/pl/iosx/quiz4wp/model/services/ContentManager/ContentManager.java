package pl.iosx.quiz4wp.model.services.ContentManager;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;
import pl.iosx.quiz4wp.model.services.ApiManager.ApiManager;
import pl.iosx.quiz4wp.model.services.DbManager.DbManager;

/**
 * Created by lukaszwroblewski on 01.04.2018.
 */
@Singleton
public class ContentManager {

    boolean isDownloaded = false;
    boolean isLocked = false;
    private List<QuizModel> quizModels;
    protected ApiManager apiManager;
    protected DbManager dbManager;

    @Inject
    public ContentManager(Context context) {
        apiManager = new ApiManager(context);
        dbManager = new DbManager(context);
    }

    public void checkUpdate(final ContentManagerModules.CheckBaseListener checkBaseListener, boolean downloadContents)
    {
        setQuizModels(new ArrayList<QuizModel>());
        ContentManagerModules.UpdateAllContent(this,checkBaseListener);
       // ContentManagerModules.CheckUpdate(this, checkBaseListener,downloadContents);
    }

    public void downloadContentFor(QuizModel quizModel, ApiManager.DownloadListListener downloadListListener)
    {
        List<QuizModel> models = new ArrayList<>();
        models.add(quizModel);
        apiManager.downloadContentForQuizListAsync(models,downloadListListener);
    }

    protected void setQuizModels(List<QuizModel> quizModels) {
        this.quizModels = quizModels;
        if(quizModels==null)
            this.quizModels = new ArrayList<>();
    }

    public List<QuizModel> getQuizModels() {
        return quizModels;
    }

    public boolean hasQuizModels()
    {
        return (quizModels!=null && quizModels.size()>0);
    }

    public boolean isDownloaded() {
        return isDownloaded;
    }

    public void setDownloaded(boolean downloaded) {
        isDownloaded = downloaded;
    }

    public boolean isLocked() {
        return isLocked;
    }

    protected void setLocked(boolean locked) {
        isLocked = locked;
    }
}
