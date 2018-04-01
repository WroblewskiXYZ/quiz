package pl.iosx.quiz4wp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;
import pl.iosx.quiz4wp.model.services.ApiManager.ApiManager;

public class MainActivity extends AppCompatActivity {

    @Inject
    ApiManager apiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        QuizApp.getApp().getApplicationComponent().inject(this);

        apiManager.getAllEmptyQuizModelsAsync(new ApiManager.ApiResponseListener() {
            @Override
            public void onReceived(List<QuizModel> models) {
                Toast.makeText(getApplicationContext(),"download", Toast.LENGTH_LONG);
            }

            @Override
            public void onFailure() {
                Toast.makeText(getApplicationContext(),"failure", Toast.LENGTH_LONG);
            }
        });
    }
}
