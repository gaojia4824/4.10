package base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<V extends IView>implements IPresenter {
    private WeakReference<V> weakReference;
    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    //用来关联v层和p层的方法
    public void attachView(V view){
        weakReference=new WeakReference <V>(view);
    }
    //用来关联v层和p层的方法释放v层
    public void dettachView(){
        if (weakReference!=null){
            weakReference.clear();
            weakReference=null;
        }
        //断开网络开关
        deleteDisposable();
    }
    //将所有的网络开关都添加到网络开关容器中
    public void addDisposable(Disposable disposable) {
        if (disposable != null)
            compositeDisposable.add(disposable);
    }

    //断开网络开关
    private void deleteDisposable() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
            compositeDisposable.clear();
            compositeDisposable = null;
        }

    }
}
