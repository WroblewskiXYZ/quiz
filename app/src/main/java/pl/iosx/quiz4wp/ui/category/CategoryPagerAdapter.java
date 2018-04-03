package pl.iosx.quiz4wp.ui.category;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by lukaszwroblewski on 03.04.2018.
 */

public class CategoryPagerAdapter extends FragmentStatePagerAdapter {

    private int count;

    public CategoryPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.count = 0;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return null;// FragmentAll.newInstance return all quiz
            case 1:
                return null;// FragmentCategory1.newInstance return list of quiz of one category ;
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
