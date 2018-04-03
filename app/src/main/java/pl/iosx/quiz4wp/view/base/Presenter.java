package pl.iosx.quiz4wp.view.base;

import javax.inject.Inject;

import pl.iosx.quiz4wp.QuizApp;
import pl.iosx.quiz4wp.model.services.ContentManager.ContentManager;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public class Presenter {

    @Inject
    public ContentManager contentManager;

    public Presenter()
    {
        QuizApp.getApp().getApplicationComponent().inject(this);
    }
}
