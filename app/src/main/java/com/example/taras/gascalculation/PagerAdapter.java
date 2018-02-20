package com.example.taras.gascalculation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Taras on 20.02.2018.
 */

public class PagerAdapter extends FragmentStatePagerAdapter{

    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int  NumberOfTabs){
        super(fm);
        this.mNumOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                LauncherFragment launcherFragment = new LauncherFragment();
                return launcherFragment;
            case 1:
                ResultFragment resultFragment = new ResultFragment();
                return resultFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
