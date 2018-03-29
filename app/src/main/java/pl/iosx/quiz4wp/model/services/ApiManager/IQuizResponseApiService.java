package pl.iosx.quiz4wp.model.services.ApiManager;

import pl.iosx.quiz4wp.model.data.apiData.QuizResponse;
import pl.iosx.quiz4wp.model.data.apiData.quizContent.QuizContent;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by lukaszwroblewski on 28.03.2018.
 */

public interface IQuizResponseApiService {

    @GET("api/v1/quizzes/0/100")
    Call<QuizResponse> getQuizList();

    @GET("api/v1/quiz/{id_quizu}/0")
    Call<QuizContent> getQuizContent(@Path("id_quizu") String quiz_id);
}
