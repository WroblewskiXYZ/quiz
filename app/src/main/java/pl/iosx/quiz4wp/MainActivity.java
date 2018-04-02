package pl.iosx.quiz4wp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import pl.iosx.quiz4wp.model.services.ContentManager.ContentManager;
import pl.iosx.quiz4wp.model.services.ContentManager.ContentManagerModules;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Inject
    ContentManager contentManager;
    TextView tvHello;

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        QuizApp.getApp().getApplicationComponent().inject(this);

        tvHello = (TextView)findViewById(R.id.tvHello);
        tvHello.setOnClickListener(this);
    }

    int counter= 0;
    public void asc()
    {
        @SuppressLint("StaticFieldLeak") AsyncTask<Void,Void,Void> newTask = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                tvHello.setText("counter: " + counter++);
            }

        };
        newTask.execute();
    }

    @Override
    public void onClick(View view) {
        if(!contentManager.isLocked())
        contentManager.checkUpdate(new ContentManagerModules.CheckBaseListener() {
            @Override
            public void onDownloading(int progress) {
                tvHello.setText("Downloading: " + progress);
            }

            @Override
            public void onReading(int progress) {
                tvHello.setText("Reading: " + progress);
            }

            @Override
            public void onSaving(int progress) {
                tvHello.setText("Saving: " + progress);
            }

            @Override
            public void onContentReady(boolean download) {
                tvHello.setText("Content ready");
            }

            @Override
            public void onUnableToProvideContent() {
                tvHello.setText("Unable to provide content");
            }
        }, false);
    }
}
