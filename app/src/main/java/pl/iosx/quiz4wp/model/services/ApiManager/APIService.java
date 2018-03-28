package pl.iosx.quiz4wp.model.services.ApiManager;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lukaszwroblewski on 28.03.2018.
 */

public class APIService {

    static final String BASE_URL = "http://quiz.o2.pl/";
    Retrofit retrofit;
    Context context;

    public APIService(Context context)
    {
        this.context = context;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
