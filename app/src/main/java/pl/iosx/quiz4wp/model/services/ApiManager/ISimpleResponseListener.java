package pl.iosx.quiz4wp.model.services.ApiManager;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by lukaszwroblewski on 28.03.2018.
 */

public interface ISimpleResponseListener<T>{

    void onSuccessfulResponse(Call<T> call, Response<T> responseResponse);
    void onFailure(Call<T> call, Response<T> responseResponse, Exception e);
}


