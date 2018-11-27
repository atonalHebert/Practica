package com.practica.hebert.fragmentsmenus.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PageAdapter extends FragmentPagerAdapter {

    // se recibe un conjunto de Fragments en un objeto ArrayList
    ArrayList<Fragment> fragments ;

    public PageAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments ;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i) ;
    }

    @Override
    public int getCount() {
        return fragments.size() ;
    }
} // fin de la clase PageAdapter
