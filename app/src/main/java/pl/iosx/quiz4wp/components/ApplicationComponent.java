package pl.iosx.quiz4wp.components;

import javax.inject.Singleton;

import dagger.Component;
import pl.iosx.quiz4wp.QuizApp;
import pl.iosx.quiz4wp.ui.base.Presenter;

/**
 * Created by lukaszwroblewski on 28.03.2018.
 */
@Component(modules = ContextModule.class)
@Singleton
public interface ApplicationComponent{

    void inject(QuizApp quizApp);
    void inject(Presenter presenter);
}
