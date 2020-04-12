package com.example.myapplication.mvp.view.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.base.BasePresenter;


public abstract class lazyFragment2 extends BaseFragment {

    //Fragment是否初始化了
    private boolean mInitView = false;
    //Fragment是否对用户可见
    private boolean mVisibleToUser = false;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mInitView = true;
        initLazyLoad();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        mVisibleToUser = isVisibleToUser;
        initLazyLoad();
    }


    protected void initLazyLoad() {
        if (!mInitView)
            return;

        //如果Fragment对用户可见了并且没加载数据
        if (mVisibleToUser) {
            //开始加载没问题
            lazyLoad();
        }

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mInitView = false;
        mVisibleToUser = false;
    }


    protected abstract void lazyLoad();

    @Override
    protected abstract void initInject();

    @Override
    protected abstract BasePresenter createPresenter();

    @Override
    protected abstract int getLayoutId();

    @Override
    public abstract void getSucceed(Object o);

    @Override
    public abstract void getError(String str);

}
