package pl.iosx.quiz4wp.ui.category.playquiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.iosx.quiz4wp.R;
import pl.iosx.quiz4wp.model.data.dataUnit.QuizModel;
import pl.iosx.quiz4wp.ui.base.BaseFragment;
import pl.iosx.quiz4wp.ui.category.filteredquizlist.FilteredQuizListMvpView;
import pl.iosx.quiz4wp.ui.category.filteredquizlist.FilteredQuizListPresenter;
import pl.iosx.quiz4wp.ui.category.filteredquizlist.FilteredQuizListRecyclerAdapter;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public class PlayQuizFragment<V extends PlayQuizMvpView> extends BaseFragment
        implements PlayQuizMvpView{


    PlayQuizMvpPresenter<PlayQuizMvpView> presenter;

    public static PlayQuizFragment newInstance() {
        Bundle args = new Bundle();
        PlayQuizFragment fragment = new PlayQuizFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_playquiz,container,false);
        ButterKnife.bind(this,view);
        presenter = new PlayQuizPresenter<>(view.getContext());
        presenter.onAttach(this);

        return view;
    }

    @Override
    protected void setUp(View view) {


        presenter.onViewPrepared();

    }

    @Override
    public void onItemsUpdate(List<QuizModel> quizModels) {
    }
}
