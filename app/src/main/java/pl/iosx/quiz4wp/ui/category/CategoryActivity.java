package pl.iosx.quiz4wp.ui.category;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import pl.iosx.quiz4wp.R;
import pl.iosx.quiz4wp.ui.base.BaseActivity;
import pl.iosx.quiz4wp.ui.category.filteredquizlist.FilteredQuizListFragment;
import pl.iosx.quiz4wp.ui.category.filteredquizlist.FilteredQuizListPresenter;
import pl.iosx.quiz4wp.ui.category.finishquiz.FinishQuizFragment;
import pl.iosx.quiz4wp.ui.category.finishquiz.FinishQuizPresenter;
import pl.iosx.quiz4wp.ui.category.playquiz.PlayQuizFragment;
import pl.iosx.quiz4wp.ui.category.playquiz.IPlayQuizMvpPresenter;

public class CategoryActivity extends BaseActivity implements ICategoryMvpView {

    ICategoryMvpPresenter categoryMvpPresenter;

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, CategoryActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        categoryMvpPresenter = new CategoryPresenter(this);
        ButterKnife.bind(this);
        setUp();
    }

    @Override
    protected void setUp() {
        List<android.support.v4.app.Fragment> list = new ArrayList<>(2);
        categoryMvpPresenter.onAttach(this);
    }

    @Override
    public void onQuizListShow(int screen, FilteredQuizListPresenter filteredQuizListPresenter) {
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        FilteredQuizListFragment fragment = FilteredQuizListFragment.newInstance();
        fragment.setRetainInstance(true);
        fragment.setPresenter(filteredQuizListPresenter);
        showFragment(fragment,R.anim.enter_right,R.anim.exit_left);

    }

    @Override
    public void onPlayQuizShow(int screen, IPlayQuizMvpPresenter playQuizMvpPresenter) {
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        PlayQuizFragment fragment = PlayQuizFragment.newInstance();
        fragment.setRetainInstance(true);
        fragment.setPresenter(playQuizMvpPresenter);
        showFragment(fragment,R.anim.enter_left,R.anim.exit_right);
    }

    @Override
    public void onFinishQuizShow(int screen, FinishQuizPresenter finishQuizPresenter) {
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        FinishQuizFragment fragment = FinishQuizFragment.newInstance();
        fragment.setRetainInstance(true);
        fragment.setPresenter(finishQuizPresenter);
        showFragment(fragment,R.anim.enter_left,R.anim.exit_right);
    }

    @Override
    public void onErrorMessage(String message) {
        showMessage(message);
    }

    private void showFragment(android.support.v4.app.Fragment fragment, int animEnter, int animExit)
    {
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_frame,fragment);
        fragmentTransaction.setCustomAnimations(animEnter,animExit);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
