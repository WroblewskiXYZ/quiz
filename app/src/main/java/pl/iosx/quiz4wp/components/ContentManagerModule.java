package pl.iosx.quiz4wp.components;

import dagger.Module;
import dagger.Provides;
import pl.iosx.quiz4wp.QuizApp;
import pl.iosx.quiz4wp.model.services.ContentManager.ContentManager;

/**
 * Created by lukaszwroblewski on 28.03.2018.
 */

@Module
public class ContentManagerModule {

    @Provides
    ContentManager provideApiService(QuizApp app)
    {
        return new ContentManager(app);
    }
}
