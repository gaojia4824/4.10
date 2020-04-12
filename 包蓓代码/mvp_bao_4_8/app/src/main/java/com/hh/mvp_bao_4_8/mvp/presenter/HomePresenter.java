package com.hh.mvp_bao_4_8.mvp.presenter;

import android.util.Log;

import com.hh.mvp_bao_4_8.app.App;
import com.hh.mvp_bao_4_8.base.BasePresenter;
import com.hh.mvp_bao_4_8.di.component.DaggerHomeComponent;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

public class HomePresenter extends BasePresenter {
    @Inject
    OkHttpClient okHttpClient;
    public HomePresenter(){
        DaggerHomeComponent.builder()
                .appComponent(App.daggerAppComponent())
                .build()
                .inject(this);
    }
    //向M层请求数据
    @Override
    public void start(Object obj){
        super.start(obj);
        Log.e("TAG",okHttpClient.toString());
        if (obj instanceof Integer){
            Integer  type= (Integer) obj;
            switch (type){
                case 0:
                    Log.e("TAG","第一个fragment加载数据。");
                    break;
                case 1:
                    Log.e("TAG","第二个fragment加载数据。");
                    break;
                case 2:
                    Log.e("TAG","第三个fragment加载数据。");
                    break;
                case 3:
                    Log.e("TAG","第四个fragment加载数据。");
                    break;
            }
        }
    }
}
