package pl.iosx.quiz4wp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import pl.iosx.quiz4wp.model.data.apiData.QuizResponse;
import pl.iosx.quiz4wp.model.data.apiData.quizContent.QuizContent;
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

        apiService.getQuizResponse(new IResponseListener<QuizResponse>() {
            @Override
            public void onSuccessfulResponse(Call<QuizResponse> call, Response<QuizResponse> responseResponse) {
                QuizResponse quizResponse = responseResponse.body();
                apiService.getQuizContent("" + quizResponse.getQuizItemItems().get(0).getId(), new IResponseListener<QuizContent>() {
                    @Override
                    public void onSuccessfulResponse(Call<QuizContent> call, Response<QuizContent> responseResponse) {
                        QuizContent quizContent = responseResponse.body();
                    }

                    @Override
                    public void onFailureResponse(Call<QuizContent> call, Response<QuizContent> responseResponse) {

                    }

                    @Override
                    public void onFailure(Call<QuizContent> call, Throwable t) {

                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
            }

            @Override
            public void onFailureResponse(Call<QuizResponse> call, Response<QuizResponse> responseResponse) {

            }

            @Override
            public void onFailure(Call<QuizResponse> call, Throwable t) {

            }

            @Override
            public void onError(Exception e) {

            }
        });

    }
}
