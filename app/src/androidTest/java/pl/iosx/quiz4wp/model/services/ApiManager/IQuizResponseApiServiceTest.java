package pl.iosx.quiz4wp.model.services.ApiManager;

import org.junit.Test;

import pl.iosx.quiz4wp.model.data.QuizResponse;
import pl.iosx.quiz4wp.model.data.quizContent.QuizContent;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.*;

/**
 * Created by lukaszwroblewski on 28.03.2018.
 */
public class IQuizResponseApiServiceTest {
    @Test
    public void shouldGetQuizContent() throws Exception {
        String BASE_URL = "http://quiz.o2.pl/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IQuizResponseApiService IQuizResponseApiService = retrofit.create(IQuizResponseApiService.class);

        Call<QuizContent> call = IQuizResponseApiService.getQuizContent("6234787811510401");

        Response<QuizContent> response = call.execute();
        QuizContent quizContent = response.body();

        assertTrue(response.isSuccessful());
    }



    @Test
    public void shouldGetQuizList() throws Exception {

        String BASE_URL = "http://quiz.o2.pl/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IQuizResponseApiService IQuizResponseApiService = retrofit.create(IQuizResponseApiService.class);

        Call<QuizResponse> call = IQuizResponseApiService.getQuizList();

        Response<QuizResponse> response = call.execute();
        QuizResponse quizResponse = response.body();

        assertTrue(response.isSuccessful());
        assertTrue(quizResponse.getCount()>0);
        assertTrue(quizResponse.getCount() == quizResponse.getQuizItems().size());
    }



}