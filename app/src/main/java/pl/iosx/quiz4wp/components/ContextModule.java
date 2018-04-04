package pl.iosx.quiz4wp.components;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import pl.iosx.quiz4wp.QuizApp;
import pl.iosx.quiz4wp.model.services.ContentManager.ContentManager;

/**
 * Created by lukaszwroblewski on 28.03.2018.
 */

@Module
public class ContextModule {
    Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    Context context() {
        return context;
    }
}

