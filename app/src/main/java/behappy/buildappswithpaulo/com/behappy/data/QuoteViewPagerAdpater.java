package behappy.buildappswithpaulo.com.behappy.data;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by paulodichone on 11/8/17.
 */

public class QuoteViewPagerAdpater
        extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    public QuoteViewPagerAdpater(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }
}
