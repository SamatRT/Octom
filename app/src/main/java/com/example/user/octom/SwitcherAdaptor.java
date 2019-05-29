package com.example.user.octom;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.ListFragment;

import java.util.List;

public class SwitcherAdaptor extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList;

    public SwitcherAdaptor(FragmentManager fm, List<Fragment> fragmentList)
    {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return  fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
