package com.example.sefu.awesomeloginui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.sefu.awesomeloginui.fragment.ActiveFragment;
import com.example.sefu.awesomeloginui.fragment.ArchivedFragment;


/**
 * Created by sefu on 4/29/2017.
 */

public class Pager extends FragmentStatePagerAdapter {

    int tabCount;

    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                ActiveFragment active = new ActiveFragment();
                return active;
            case 1:
                ArchivedFragment archivedFragment = new ArchivedFragment();
                return archivedFragment;

            default:
                return null;

        }


    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
