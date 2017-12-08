package com.vistagram.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Hamrahan on 11/28/2017.
 */

public class ProfileTabLayout_Adapter  extends FragmentPagerAdapter {


    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    ArrayList<String> tabArrayList = new ArrayList<>();


    public ProfileTabLayout_Adapter(FragmentManager fm) {
        super(fm);

    }


    /* (non-Javadoc)
     * @see android.support.v4.app.FragmentPagerAdapter#getItem(int)
     */
    @Override
    public Fragment getItem(int position) {
        return this.fragmentArrayList.get(position);
    }

    /* (non-Javadoc)
     * @see android.support.v4.view.PagerAdapter#getCount()
     */
    @Override
    public int getCount() {
        return this.fragmentArrayList.size();
    }

    public  void add(Fragment fragment){
        fragmentArrayList.add(fragment);

    }


}
