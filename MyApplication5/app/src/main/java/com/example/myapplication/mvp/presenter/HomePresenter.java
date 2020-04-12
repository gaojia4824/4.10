package com.example.myapplication.mvp.presenter;

import android.util.Log;

import com.example.myapplication.base.BasePresenter;

public class HomePresenter extends BasePresenter {
    @Override
    public void start(Object o) {
        super.start(o);
        if (o instanceof Integer) {
            Integer type = (Integer) o;
            switch (type) {
                case 0:
                    Log.e("TAG", "第一个Fragment");
                    break;
                case 1:
                    Log.e("TAG", "第二个Fragment");
                    break;
                case 2:
                    Log.e("TAG", "第三个Fragment");
                    break;
                case 3:
                    Log.e("TAG", "第四个Fragment");
                    break;
            }


        }
    }
}