package pl.iosx.quiz4wp.ui.category.playquiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.iosx.quiz4wp.R;
import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QImage;
import pl.iosx.quiz4wp.ui.base.BaseFragment;
import pl.iosx.quiz4wp.ui.category.filteredquizlist.FilteredQuizListMvpView;
import pl.iosx.quiz4wp.ui.category.filteredquizlist.FilteredQuizListPresenter;
import pl.iosx.quiz4wp.ui.category.filteredquizlist.FilteredQuizListRecyclerAdapter;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public class PlayQuizFragment<V extends PlayQuizMvpView> extends BaseFragment
        implements PlayQuizMvpView {


    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.pbProgress)
    ProgressBar progressBar;

    @BindView(R.id.tv_content)
    TextView tvContent;

    @BindView(R.id.iv_image)
    ImageView ivImage;

    @BindView(R.id.btn_answer1)
    Button btnAnswer1;

    @BindView(R.id.btn_answer2)
    Button btnAnswer2;

    @BindView(R.id.btn_answer3)
    Button btnAnswer3;

    @BindView(R.id.btn_answer4)
    Button btnAnswer4;

    PlayQuizMvpPresenter<PlayQuizMvpView> presenter;

    public static PlayQuizFragment newInstance() {
        Bundle args = new Bundle();
        PlayQuizFragment fragment = new PlayQuizFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public void setPresenter(PlayQuizMvpPresenter<PlayQuizMvpView> presenter) {
        this.presenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_playquiz, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void setUp(View view) {
        presenter.onAttach(this);
    }

    @Override
    public void onQuestionTitleUpdate(String title) {
        tvTitle.setText(title);
    }

    @Override
    public void onProgressUpdate(int max, int progress) {
        progressBar.setMax(max);
        progressBar.setProgress(progress);
    }

    @Override
    public void onImageContentUpdate(boolean visible, QImage image) {
        if (visible && image != null && image.getUrl() != null && image.getUrl().length() > 0) {
            ivImage.setVisibility(View.VISIBLE);
            Glide.with(ivImage.getContext())
                    .load(image.getUrl())
                    .asBitmap()
                    .centerCrop()
                    .into(ivImage);
        } else {
            ivImage.setVisibility(View.GONE);
        }
    }

    @Override
    public void onQuestionContentUpdate(String question_content) {
        tvContent.setText(question_content);
    }

    @Override
    public void onAnswerButtonUpdate(int answer, boolean visible, String label) {
        switch (answer) {
            case 1:
                btnAnswer1.setVisibility(visible ? View.VISIBLE : View.GONE);
                btnAnswer1.setText(label);
                break;
            case 2:
                btnAnswer2.setVisibility(visible ? View.VISIBLE : View.GONE);
                btnAnswer2.setText(label);
                break;
            case 3:
                btnAnswer3.setVisibility(visible ? View.VISIBLE : View.GONE);
                btnAnswer3.setText(label);
                break;
            case 4:
                btnAnswer4.setVisibility(visible ? View.VISIBLE : View.GONE);
                btnAnswer4.setText(label);
                break;
        }
    }

    @Override
    public void onEnableAllButtons(boolean enable) {
        btnAnswer1.setEnabled(enable);
        btnAnswer2.setEnabled(enable);
        btnAnswer3.setEnabled(enable);
        btnAnswer4.setEnabled(enable);
    }

    @OnClick(R.id.btn_answer1)
    public void onAnswerButton1Click(View view)
    {
        presenter.onAnswerButtonClick(1);
    }

    @OnClick(R.id.btn_answer2)
    public void onAnswerButton2Click(View view)
    {
        presenter.onAnswerButtonClick(2);
    }

    @OnClick(R.id.btn_answer3)
    public void onAnswerButton3Click(View view)
    {
        presenter.onAnswerButtonClick(3);
    }

    @OnClick(R.id.btn_answer4)
    public void onAnswerButton4Click(View view)
    {
        presenter.onAnswerButtonClick(4);
    }

}
