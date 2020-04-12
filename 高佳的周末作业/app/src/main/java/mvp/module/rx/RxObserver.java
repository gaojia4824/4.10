package mvp.module.rx;

import android.util.Log;

import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import callback.IDataCallBack;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class RxObserver<T> implements Observer<T> {
    private IDataCallBack dataCallBack;
    public RxObserver(IDataCallBack dataCallBack){
        this.dataCallBack=dataCallBack;
    }
    public void onSubscribe(Disposable d){
        dataCallBack.onReseponseDiposable(d);
    }
    public abstract void onNext(T value);
    //IO异常 connection异常,Socket异常
    @Override
    public void onError(Throwable e) {
        if (e instanceof SocketTimeoutException) {
            dataCallBack.onFaileData("SocketTimeoutException");
            Log.e("TAG", "SocketTimeoutException");
        } else if (e instanceof SocketException) {
            dataCallBack.onFaileData("SocketException");
            Log.e("TAG", "SocketException");
        } else if (e instanceof UnknownHostException) {
            dataCallBack.onFaileData("UnknownHostException");
            Log.e("TAG", "UnknownHostException");
        } else if (e instanceof ConnectException) {
            dataCallBack.onFaileData("ConnectException");
            Log.e("TAG", "ConnectException");
        } else {
            if (e != null) {
                Log.e("TAG", e.getMessage()+"==");
                dataCallBack.onFaileData(e.getMessage());
            }else{
                Log.e("TAG","空......");
            }
        }

    }
    @Override
    public void onComplete() {
        Log.e("TAG", "data complete...");
    }
}
