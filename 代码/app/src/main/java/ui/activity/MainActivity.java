package ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import base.BaseActivity;
import base.BasePresenter;
import base.IView;
import entity.ChaptersListInfo;
import mvp.persenter.MainPersenter;

import android.os.Bundle;
import android.util.Log;

import com.hh.mvp330.R;

import java.util.List;

public class MainActivity extends BaseActivity {

    @Override
    protected int initView() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter createPresenter() {
        return new MainPersenter(this);
    }

    @Override
    protected IView createView() {
        return this;
    }

    @Override
    protected void onStart() {
        //向p层发送请求数据的命令
        getPresenter().satrt();
        super.onStart();
    }

    @Override
    public void onScuess(Object o) {
        if (o instanceof ChaptersListInfo){
            ChaptersListInfo chaptersListInfo= (ChaptersListInfo) o;
            List <ChaptersListInfo.DataBean> dataList = chaptersListInfo.getData();
            for (ChaptersListInfo.DataBean dataBean:dataList){
                //v层获取数据之后就可以更新ui
                Log.i("TAG",dataBean.toString());
            }
        }
    }

    @Override
    public void onFaile(String msg) {
        //v层获取数据之后更新ui
        Log.e("TAG","请求失败"+msg);
    }
}
