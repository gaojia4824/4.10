package com.example.myapplication.Api;

import android.content.SharedPreferences;

import com.example.myapplication.Molder.AppModule;
import com.example.myapplication.Presenter.Mainpresenter;
import com.example.myapplication.base.BaseView;

import javax.inject.Singleton;

import dagger.Component;
@Singleton
@Component(modules = {AppModule.class,okmanager.class})
public interface Appcomponent {
       //SharedPreferences shar();
       void injiet(Mainpresenter v);
}
