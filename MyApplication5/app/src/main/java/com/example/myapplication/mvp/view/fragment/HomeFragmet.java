package com.example.myapplication.mvp.view.fragment;

import android.util.Log;

import com.example.myapplication.R;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.base.BaseView;
import com.example.myapplication.mvp.presenter.HomePresenter;


import java.util.concurrent.ThreadPoolExecutor;

public class HomeFragmet extends lazyFragment {
    private int type;

    public HomeFragmet(int i) {
        type = i;
    }


    @Override
    protected void stopLazyLoad() {
        switch (type) {
            case 0:
                Log.e("TAG", "1Frgment停止加载");
                break;
            case 1:
                Log.e("TAG", "2Frgment停止加载");
                break;
            case 2:
                Log.e("TAG", "3Frgment停止加载");
                break;
            case 3:
                Log.e("TAG", "4Frgment停止加载");
                break;
        }
    }

    @Override
    protected void lazyLoad() {
        getmPresenter().start(type);
    }

    @Override
    protected void initInject() {

    }

    @Override
    protected BaseView createView() {
        return null;
    }


    @Override
    protected BasePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int getLayoutId() {
        Integer layoutId = switchLayout(type);
        if (layoutId != null)
            return layoutId;
        return 0;
    }

    private static Integer switchLayout(int mType) {
        switch (mType) {
            case 0:
                return R.layout.fragment_home;
            case 1:
                return R.layout.fragment_navigation;
            case 2:
                return R.layout.fragment_tixi;

            case 3:
                return R.layout.fragment_gongzhonghao;
        }
        return null;
    }

    @Override
    public void getSucceed(Object o) {

    }

    @Override
    public void getError(String str) {

    }
}
