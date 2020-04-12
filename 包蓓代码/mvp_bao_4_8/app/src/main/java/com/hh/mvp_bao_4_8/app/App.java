package com.hh.mvp_bao_4_8.app;

import android.app.Activity;
import android.app.Application;
import android.os.Process;

import com.hh.mvp_bao_4_8.di.component.DaggerAppComponent;
import com.hh.mvp_bao_4_8.di.module.AppModule;

import java.util.HashSet;
import java.util.Set;

public class App extends Application {
    public static App mInstance;
    private Set <Activity> mActivities;
    private static  DaggerAppComponent mDaggerAppComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
        initInject();
    }

    private void initInject() {
        if (mDaggerAppComponent==null){
            mDaggerAppComponent=(DaggerAppComponent) DaggerAppComponent.builder()
                    .appModule(new AppModule(this)).build();
        }
    }
    public static DaggerAppComponent daggerAppComponent() {
        return mDaggerAppComponent;
    }


    public static synchronized App getInstance() {
        return mInstance;
    }


    public void addActivity(Activity act) {
        if (mActivities == null)
            mActivities = new HashSet <Activity>();
        mActivities.add(act);
    }

    public void removeActivity() {
        if (mActivities != null) {
            for (Activity act : mActivities) {
                act.finish();
            }
        }
        Process.killProcess(Process.myPid());
        System.exit(0);
    }

}
