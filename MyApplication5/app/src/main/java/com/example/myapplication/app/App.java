package com.example.myapplication.app;

import android.app.Activity;
import android.app.Application;
import android.os.Process;

import java.util.HashSet;
import java.util.Set;

public class App extends Application {
    private static App instance;
    private Set<Activity> activityset;

    //
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initDagger2();
    }

    //dagger2
    private void initDagger2() {
    }

    //将对象返回出去
    public static synchronized App getInstance() {
        return instance;
    }


    //添加activity
    public void addActivity(Activity act) {
        if (activityset == null)
            activityset = new HashSet<Activity>();
        activityset.add(act);
    }

    //将每个activity移除
    public void removeActivity() {
        if (activityset != null) {
            for (Activity act : activityset) {
                act.finish();
            }
        }
        Process.killProcess(Process.myPid());
        System.exit(0);
    }


}
