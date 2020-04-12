package com.example.myapplication.base;

import android.sax.StartElementListener;

import java.lang.ref.WeakReference;
import java.nio.file.ClosedWatchServiceException;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<V extends BaseView<T>, T> implements BasePresent<T> {

    //P层 的基类
    private WeakReference<V> weakReference;  //弱引用
    private CompositeDisposable compositeDisposable; //网络开关容器

    public void addView(V view) {
        if (weakReference == null) {
            weakReference = new WeakReference<V>(view);
        }
    }

    public void deleteView() {
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
        //断开网络开关
        disconnectDisposable();
    }

    public void addDisposable(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
            compositeDisposable.add(disposable);

        }
    }


    public void disconnectDisposable() {
        if (compositeDisposable != null && compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
            compositeDisposable.clear();
            compositeDisposable = null;
        }
    }

    ;

    @Override
    public void start() {

    }

    @Override
    public void start(T t) {

    }
}
