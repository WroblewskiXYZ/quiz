package pl.iosx.quiz4wp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import pl.iosx.quiz4wp.model.data.dataUnit.ApiQuizContent;
import pl.iosx.quiz4wp.model.data.dataUnit.ApiQuizListResponse;
import pl.iosx.quiz4wp.model.services.ApiManager.APIService;
import pl.iosx.quiz4wp.model.services.ApiManager.IResponseListener;
import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Inject
    APIService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        QuizApp.getApp().getApplicationComponent().inject(this);

        apiService.getQuizResponse(new IResponseListener<ApiQuizListResponse>() {
            @Override
            public void onSuccessfulResponse(Call<ApiQuizListResponse> call, Response<ApiQuizListResponse> responseResponse) {
                ApiQuizListResponse apiQuizListResponse = responseResponse.body();
                apiService.getQuizContent("" + apiQuizListResponse.getApiQuizItemItems().get(0).getId(), new IResponseListener<ApiQuizContent>() {
                    @Override
                    public void onSuccessfulResponse(Call<ApiQuizContent> call, Response<ApiQuizContent> responseResponse) {
                        ApiQuizContent apiQuizContent = responseResponse.body();


                    }

                    @Override
                    public void onFailureResponse(Call<ApiQuizContent> call, Response<ApiQuizContent> responseResponse) {
                        System.out.println("onFailureResponse");
                    }

                    @Override
                    public void onFailure(Call<ApiQuizContent> call, Throwable t) {
                        System.out.println("onFailureResponse");

                    }

                    @Override
                    public void onError(Exception e) {
                        System.out.println("onFailureResponse");

                    }
                });
            }

            @Override
            public void onFailureResponse(Call<ApiQuizListResponse> call, Response<ApiQuizListResponse> responseResponse) {
                System.out.println("onFailureResponse");

            }

            @Override
            public void onFailure(Call<ApiQuizListResponse> call, Throwable t) {
                System.out.println("onFailureResponse");

            }

            @Override
            public void onError(Exception e) {
                System.out.println("onFailureResponse");

            }
        });

    }
}
