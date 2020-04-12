package com.example.myapplication.mvp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.mvp.view.adapter.HomeVpAdapter;
import com.example.myapplication.mvp.view.fragment.HomeFragmet;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeActivity extends BaseActivity {
    @BindView(R.id.home_viewpager)
    ViewPager viewPager;
    @BindView(R.id.home_navigation)
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onViewCreated() {
        List<HomeFragmet> fragments = getHomeFragmets();
        HomeVpAdapter adapter = new HomeVpAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
    }

    @Override
    protected void initListenner() {

        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.item_home:
                    Log.e("TAG", "00000000");
                    switchTab(0);
                    break;
                case R.id.item_navigation:
                    Log.e("TAG", "000000011111111110");
                    switchTab(1);
                    break;
                case R.id.item_tixi:
                    Log.e("TAG", "22222");
                    switchTab(2);
                    break;
                case R.id.item_gongzhonghao:
                    switchTab(3);
                    break;
            }
            return true;
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //当ViewPager页面切换的时候让下面的tab标签跟着切换
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void switchTab(int i) {
        viewPager.setCurrentItem(i);
    }

    private List<HomeFragmet> getHomeFragmets() {
        List<HomeFragmet> fragments = new ArrayList<HomeFragmet>();
        for (int i = 0; i < 4; i++) {
            HomeFragmet homeFragmet = new HomeFragmet(i);
            fragments.add(homeFragmet);
        }
        return fragments;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }
}
