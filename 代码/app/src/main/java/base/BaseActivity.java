package base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<V extends IView,P extends BasePresenter<V>> extends
        AppCompatActivity implements IView {
    private V view;
    private P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = initView();
        if (layoutId != 0) //防止实现类里面传入的布局ID是0
            setContentView(layoutId);
        //给view赋值
        if (view == null)
            view = createView();
        //给presenter赋值
        if (presenter == null)
            presenter = createPresenter();

        //拿到P层对象和V层进行关联
        if (view != null && presenter != null) {
            presenter.attachView(view);
        }

    }
    protected abstract int initView();

    protected abstract P createPresenter();

    protected abstract V createView();
    //获取View对象
    public V getView() {
        return view;
    }

    //获取Presenter对象
    public P getPresenter() {
        return presenter;
    }


    //拿到P层对象和V层进行关联
    @Override
    protected void onDestroy() {
        if (this.view != null && this.presenter != null) {
            // 将V层引用置为null
            this.presenter.dettachView();
            //将P层引用置为null
            this.presenter=null;
        }
        super.onDestroy();
    }
}
