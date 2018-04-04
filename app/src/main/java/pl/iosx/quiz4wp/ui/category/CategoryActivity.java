package pl.iosx.quiz4wp.ui.category;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.ViewParent;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.iosx.quiz4wp.MainActivity;
import pl.iosx.quiz4wp.R;
import pl.iosx.quiz4wp.ui.base.BaseActivity;

public class CategoryActivity extends BaseActivity {

    @BindView(R.id.vp_quiz)
    ViewPager viewPager;


    CategoryPagerAdapter categoryPagerAdapter;

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, CategoryActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);
        categoryPagerAdapter = new CategoryPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(categoryPagerAdapter);
    }

    @Override
    protected void setUp() {

    }
}
