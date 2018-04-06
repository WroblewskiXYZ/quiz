package pl.iosx.quiz4wp.ui.category;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.ArrayMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import pl.iosx.quiz4wp.ui.category.filteredquizlist.FilteredQuizListFragment;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public class CategoryPagerAdapter extends FragmentStatePagerAdapter {

    private int count;

    Fragment firstFragment;
    Fragment secondFragment;

    public CategoryPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        firstFragment = FilteredQuizListFragment.newInstance();
        this.count = 1;
    }

    public void set(int page, Fragment fragment)
    {
        if(page==0)
            firstFragment = fragment;
        else
        {
            secondFragment.getFragmentManager().beginTransaction()
                    .remove(secondFragment)
                    .attach(fragment)
                    .commit();
            secondFragment = fragment;
            this.count = 2;
        }
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return firstFragment;
            case 1:
                return secondFragment;// FragmentCategory1.newInstance return list of quiz of one category ;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
