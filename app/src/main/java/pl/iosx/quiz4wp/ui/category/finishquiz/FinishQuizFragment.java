package pl.iosx.quiz4wp.ui.category.finishquiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.iosx.quiz4wp.R;
import pl.iosx.quiz4wp.model.data.dataUnit.baseModel.QImage;
import pl.iosx.quiz4wp.ui.base.BaseFragment;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public class FinishQuizFragment<V extends FinishQuizMvpView> extends BaseFragment
        implements FinishQuizMvpView {


    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_rate)
    TextView tvRate;

    @BindView(R.id.tv_content)
    TextView tvContent;

    @BindView(R.id.btn_goto_quizlist)
    Button btnGoToQuizList;

    @BindView(R.id.btn_repeat)
    Button btnRepeat;

    FinishQuizMvpPresenter<FinishQuizMvpView> presenter;

    public static FinishQuizFragment newInstance() {
        Bundle args = new Bundle();
        FinishQuizFragment fragment = new FinishQuizFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public void setPresenter(FinishQuizMvpPresenter<FinishQuizMvpView> presenter) {
        this.presenter = presenter;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_finishquiz, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void setUp(View view) {
        presenter.onAttach(this);
    }

    @Override
    public void onTitleUpdate(String title) {
        tvTitle.setText(title);
    }

    @Override
    public void onRateUpdate(String rate) {
        tvRate.setText(rate);
    }

    @Override
    public void onContentUpdate(String content) {
        tvContent.setText(content);
    }

    @OnClick(R.id.btn_goto_quizlist)
    public void onGoToQuizListButtonClick(View view)
    {
        presenter.onReturnToQuizListButtonClick();
    }

    @OnClick(R.id.btn_repeat)
    public void onRepeatQuiz(View view)
    {
        presenter.onQuizRepeatButtonClick();
    }

}
