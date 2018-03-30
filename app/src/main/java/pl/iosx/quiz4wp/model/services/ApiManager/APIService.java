package pl.iosx.quiz4wp.model.services.ApiManager;

import android.content.Context;

import javax.inject.Singleton;

import pl.iosx.quiz4wp.model.data.dataUnit.ApiQuizContent;
import pl.iosx.quiz4wp.model.data.dataUnit.ApiQuizListResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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
    }

    public void getSimpleQuizResponse(final ISimpleResponseListener<ApiQuizListResponse> responseListener)
    {
        try
        {
            QuizResponseApiService =  retrofit.create(IQuizResponseApiService.class);
            QuizResponseApiService.getQuizList().enqueue(returnResponseCallback(responseListener));
        }
        catch (Exception e)
        {
            responseListener.onFailure(null,null,e);
        }
    }

    public void getSimpleQuizContent(String quiz_id, final ISimpleResponseListener<ApiQuizContent> responseListener)
    {
        try
        {
            QuizResponseApiService =  retrofit.create(IQuizResponseApiService.class);
            QuizResponseApiService.getQuizContent(quiz_id).enqueue(returnResponseCallback(responseListener));
        }
        catch (Exception e)
        {
            responseListener.onFailure(null,null,e);
        }
    }


    public void getQuizResponse(final IResponseListener<ApiQuizListResponse> responseListener)
    {
        try
        {
            QuizResponseApiService =  retrofit.create(IQuizResponseApiService.class);
            QuizResponseApiService.getQuizList().enqueue(returnResponseCallback(responseListener));
        }
        catch (Exception e)
        {
            responseListener.onError(e);
        }
    }

    public void getQuizContent(String quiz_id, final IResponseListener<ApiQuizContent> responseListener)
    {
        try
        {
            QuizResponseApiService =  retrofit.create(IQuizResponseApiService.class);
            QuizResponseApiService.getQuizContent(quiz_id).enqueue(returnResponseCallback(responseListener));
        }
        catch (Exception e)
        {
            throw e;
            //responseListener.onError(e);
        }
    }

    private <T> Callback<T> returnResponseCallback(final IResponseListener<T> responseListener)
    {
        return new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if(response.isSuccessful())
                    responseListener.onSuccessfulResponse(call,response);
                else
                    responseListener.onFailureResponse(call,response);
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                responseListener.onFailure(call, t);
            }
        };
    }

    private <T> Callback<T> returnResponseCallback(final ISimpleResponseListener<T> responseListener)
    {
        return new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if(response.isSuccessful())
                    responseListener.onSuccessfulResponse(call,response);
                else
                    responseListener.onFailure(call,response, null);
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                responseListener.onFailure(call,null, null);
            }
        };
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
