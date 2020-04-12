package mvp.persenter;

import android.util.Log;

import base.BasePresenter;
import callback.IDataCallBack;
import constents.Constants;
import entity.ChaptersListInfo;
import io.reactivex.disposables.Disposable;
import mvp.module.rx.RxImpl;
import ui.activity.MainActivity;

public class MainPersenter extends BasePresenter {
    private MainActivity mainActivity;
    private RxImpl okImpl;
    public MainPersenter(MainActivity mainActivity) {
        this.mainActivity=mainActivity;
        okImpl=new RxImpl();
    }

    @Override
    public void satrt() {
        Log.e("TAG","onStart。。。。。。。");
        okImpl.getChaptersList(Constants.CHAPTERS_LIST, new IDataCallBack() {
            @Override
            public void onResponseData(Object obj) {
                if (obj instanceof ChaptersListInfo) {
                    ChaptersListInfo chaptersListInfo = (ChaptersListInfo) obj;
                    mainActivity.onScuess(chaptersListInfo);
                }
            }

            @Override
            public void onFaileData(String msg) {
                mainActivity.onFaile(msg);
            }

            @Override
            public void onReseponseDiposable(Disposable disposable) {
                //将所有的网络开关都添加到网络开关容器中
                addDisposable(disposable);
            }
        });
    }


    @Override
    public void start(Object o) {

    }

    @Override
    public void detachView() {

    }
}
