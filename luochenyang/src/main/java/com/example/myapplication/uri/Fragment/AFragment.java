package com.example.myapplication.uri.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.myapplication.Presenter.MainApravity;
import com.example.myapplication.R;
import com.example.myapplication.View.MainAView;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.text.BaseApp;
import com.example.myapplication.text.Data1;
import com.example.myapplication.uri.abat.DataAdaption;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogRecord;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.internal.Constants;
import okhttp3.Authenticator;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.Route;
import retrofit2.Retrofit;

public class AFragment extends BaseFragment<MainApravity> implements MainAView {
    private int i1;
    private RecyclerView mRe;
    private ArrayList<Data1.DataBean.CatalogBean> mList;
    private DataAdaption mAdaption;
    private Retrofit mRf;

    public void da(int i) {
        this.i1=i;
    }
    @Override
    protected int getfind() {
        switch (i1){
            case 0:
                return R.layout.kk;
            case 1:
                return R.layout.kk1;
            case 2:
                return R.layout.kk;

        }
        return 0;

    }
 


    @Override
    protected MainApravity initPresenter() {
        return new MainApravity();
    }
    @Override
    protected void into(View view) {
        switch (i1){
            case 0:
                mPresenter.ll();

                break;
        }
    }
    @Override
    public void setDate(Object ok) {
        switch (i1){

        }
    }

    @Override
    public void setStr(String on) {
        Toast.makeText(getContext(),on,Toast.LENGTH_SHORT).show();
    }



    }
