package pl.iosx.quiz4wp.components;

import dagger.Module;
import dagger.Provides;
import pl.iosx.quiz4wp.QuizApp;
import pl.iosx.quiz4wp.model.services.ApiManager.ApiManager;

/**
 * Created by lukaszwroblewski on 28.03.2018.
 */

@Module
public class ApiManagerModule {

    @Provides
    ApiManager provideApiService(QuizApp app)
    {
        return new ApiManager(app);
    }
}
