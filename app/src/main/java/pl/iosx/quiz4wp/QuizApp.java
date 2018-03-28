package pl.iosx.quiz4wp;

import android.app.Application;

import javax.inject.Inject;

import pl.iosx.quiz4wp.appComponent.ApplicationComponent;
import pl.iosx.quiz4wp.appComponent.DaggerApplicationComponent;
import pl.iosx.quiz4wp.model.services.ApiManager.APIService;

/**
 * Created by lukaszwroblewski on 28.03.2018.
 */

public class QuizApp extends Application {

    @Inject
    APIService apiService;

    private static QuizApp quizApp;
    private ApplicationComponent applicationComponent;

    public static QuizApp getApp()
    {
        return quizApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        quizApp = this;

        applicationComponent = DaggerApplicationComponent
                .builder()
                .application(this)
                .build();
        applicationComponent.inject(this);
    }
}
