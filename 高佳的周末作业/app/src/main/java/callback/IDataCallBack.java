package callback;

import io.reactivex.disposables.Disposable;

public interface IDataCallBack<T> {
    void onResponseData(T t);
    void onFaileData(String msg);
    void onReseponseDiposable(Disposable disposable);
}
