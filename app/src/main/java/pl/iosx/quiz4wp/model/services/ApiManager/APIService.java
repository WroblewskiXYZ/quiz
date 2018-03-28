package pl.iosx.quiz4wp.model.services.ApiManager;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lukaszwroblewski on 28.03.2018.
 */

@Singleton
public class APIService {

    static final String BASE_URL = "http://quiz.o2.pl/";

    Retrofit retrofit;
    IQuizResponseApiService QuizResponseApiService;
    Context context;

    public APIService(Context context)
    {
        this.context = context;
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        QuizResponseApiService =  retrofit.create(IQuizResponseApiService.class);
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
