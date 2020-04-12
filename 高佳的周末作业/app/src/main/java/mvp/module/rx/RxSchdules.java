package mvp.module.rx;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;


//封装线程切换的类
public class RxSchdules {
    public static <T> ObservableTransformer<T, T> io_main() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource <T> apply(Observable <T> observable) {
                Observable<T> tObservable = observable.subscribeOn(Schedulers.io()).
                        observeOn(AndroidSchedulers.mainThread());
                return tObservable;
            }
        };
    }
}
