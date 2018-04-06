package pl.iosx.quiz4wp.ui.category.filteredquizlist;

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

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public class FilteredQuizListFragment<V extends FilteredQuizListMvpView> extends BaseFragment
        implements FilteredQuizListMvpView, FilteredQuizListRecyclerAdapter.AdapterCallback {


    @BindView(R.id.rv_quizlist)
    RecyclerView recyclerView;

    FilteredQuizListRecyclerAdapter filteredQuizListRecyclerAdapter;

    FilteredQuizListPresenter<FilteredQuizListMvpView> presenter;

    public static FilteredQuizListFragment newInstance() {
        Bundle args = new Bundle();
        FilteredQuizListFragment fragment = new FilteredQuizListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public void setPresenter(FilteredQuizListPresenter<FilteredQuizListMvpView> presenter) {
        this.presenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filteredquizlist,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    protected void setUp(View view) {
        filteredQuizListRecyclerAdapter = new FilteredQuizListRecyclerAdapter();
        filteredQuizListRecyclerAdapter.setAdapterCallback(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(filteredQuizListRecyclerAdapter);
        presenter.onAttach(this);
        presenter.onViewPrepared();

    }

    @Override
    public void onItemsUpdate(List<QuizModel> quizModels) {
        if(filteredQuizListRecyclerAdapter!=null)
            filteredQuizListRecyclerAdapter.setQuizModelList(quizModels);
    }

    @Override
    public void onRetryClicked() {

    }

    @Override
    public void onItemClicked(int position, long id) {

    }
}
