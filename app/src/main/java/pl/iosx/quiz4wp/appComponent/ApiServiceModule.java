package pl.iosx.quiz4wp.appComponent;

import dagger.Module;
import dagger.Provides;
import pl.iosx.quiz4wp.QuizApp;
import pl.iosx.quiz4wp.model.services.ApiManager.APIService;

/**
 * Created by lukaszwroblewski on 28.03.2018.
 */

@Module
public class ApiServiceModule {

    @Provides
    APIService provideApiService(QuizApp app)
    {
        return new APIService(app);
    }
}
