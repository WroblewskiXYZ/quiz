package pl.iosx.quiz4wp.model.services.ApiManager;

import pl.iosx.quiz4wp.model.data.QuizResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lukaszwroblewski on 28.03.2018.
 */

public interface IResponseListener<T>{

    void onSuccessfulResponse(Call<T> call, Response<T> responseResponse);
    void onFailureResponse(Call<T> call, Response<T> responseResponse);
    void onFailure(Call<T> call, Throwable t);
    void onError(Exception e);
}

