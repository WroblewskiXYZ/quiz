package pl.iosx.quiz4wp.view.intro;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.iosx.quiz4wp.MainActivity;
import pl.iosx.quiz4wp.R;
import pl.iosx.quiz4wp.view.base.BaseActivity;

public class IntroActivity extends BaseActivity implements IntroMvpView {

    IntroMvpPresenter<IntroMvpView> presenter;

    @BindView(R.id.btn_retry)
    Button btnRetry;

    @BindView(R.id.tv_status_message)
    TextView tvStatusMessage;

    @BindView(R.id.pbProgress)
    ProgressBar pbStatus;

    @BindView(R.id.fullscreen_layout)
    View vFullScreen;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, IntroActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        ButterKnife.bind(this);

        presenter = new IntroPresenter<>(this);

        presenter.onAttach(IntroActivity.this);
        vFullScreen.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    @OnClick(R.id.btn_retry)
    void onRetryButtonClick(View v) {
        presenter.onRetryButtonClick();
    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.getIntent(this);
        startActivity(intent);
        finish();
    }

    @Override
    public void updateStatusLabel(String text) {
        tvStatusMessage.setText(text);
    }

    @Override
    public void changeButtonRetryStatus(boolean visible, boolean enable) {
        btnRetry.setVisibility(visible? View.VISIBLE: View.INVISIBLE);
        btnRetry.setEnabled(enable);
    }

    @Override
    public void updateProgressbarStatus(boolean visible, int percentage) {
        pbStatus.setVisibility(visible?View.VISIBLE:View.INVISIBLE);
        pbStatus.setMax(100);
        pbStatus.setProgress(percentage);
    }

    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {

    }
}
