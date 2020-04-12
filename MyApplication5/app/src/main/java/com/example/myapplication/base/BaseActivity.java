package com.example.myapplication.base;

import android.app.Application;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.app.App;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<T> extends AppCompatActivity implements BaseView<T> {

    private Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        int layoutId = getLayout();
        if (layoutId != 0)
            setContentView(layoutId);
        App.getInstance().addActivity(this);
        unbinder = ButterKnife.bind(this);
        onViewCreated();
        initListenner();
    }

    //
    protected abstract void onViewCreated();

    //监听
    protected abstract void initListenner();

    //加载布局
    protected abstract int getLayout();

    @Override
    public void getSucceed(T t) {

    }

    @Override
    public void getError(String str) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
        App.getInstance().removeActivity();

    }
}
