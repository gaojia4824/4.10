package com.example.myapplication.mvp.view.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplication.mvp.view.fragment.HomeFragmet;

import java.util.List;

public class HomeVpAdapter extends FragmentPagerAdapter {
    private List<HomeFragmet> fragmets;

    public HomeVpAdapter(@NonNull FragmentManager fm, List<HomeFragmet> fragments) {
        super(fm);
        this.fragmets = fragments;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmets.get(position);
    }

    @Override
    public int getCount() {
        return fragmets.size();
    }
}
