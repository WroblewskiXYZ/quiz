package pl.iosx.quiz4wp.components;

import dagger.BindsInstance;
import dagger.Component;
import pl.iosx.quiz4wp.MainActivity;
import pl.iosx.quiz4wp.QuizApp;
import pl.iosx.quiz4wp.view.base.Presenter;

/**
 * Created by lukaszwroblewski on 28.03.2018.
 */

@Component(modules = ContentManagerModule.class)
public interface ApplicationComponent{

    @Component.Builder
    interface Builder
    {
        @BindsInstance
        Builder application(QuizApp quizApp);
        ApplicationComponent build();
    }

    void inject(QuizApp quizApp);
    void inject(MainActivity activity);
    void inject(Presenter presenter);
}
