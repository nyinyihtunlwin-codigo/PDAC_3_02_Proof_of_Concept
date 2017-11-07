package projects.nyinyihtunlwin.proofofconceptscreen.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import projects.nyinyihtunlwin.proofofconceptscreen.fragments.MostPopularFragment;
import projects.nyinyihtunlwin.proofofconceptscreen.fragments.NowOnCinemaFragment;
import projects.nyinyihtunlwin.proofofconceptscreen.fragments.UpcomingFragment;

/**
 * Created by Dell on 11/7/2017.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    Fragment fragment;

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                fragment = NowOnCinemaFragment.newInstance("", "");
                break;
            case 1:
                fragment = UpcomingFragment.newInstance("", "");
                break;
            case 2:
                fragment = MostPopularFragment.newInstance("", "");
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }
}
