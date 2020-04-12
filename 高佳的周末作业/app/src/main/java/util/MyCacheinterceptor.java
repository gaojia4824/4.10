package util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;



import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class MyCacheinterceptor implements Interceptor {

    private Context Context;

    @Override
    public Response intercept(Chain chain) throws IOException {
        //1.获取请求数据
        Request request = chain.request();
        //2.判断如果无网时，设置缓存协议
        if (!isNetworkAvailable(Context)) {
            request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();

        }
        //3.开始请求网络，获取响应数据
        Response originalResponse = chain.proceed(request);
        //4.判断是否有网
        if (isNetworkAvailable(Context)) {
            //有网，获取网络数据
            int maxAge = 0;
            return originalResponse.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public ,max-age=" + maxAge)
                    .build();
        } else {
            //没有网络，获取缓存数据
            int maxStale = 15 * 60;
            return originalResponse.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .build();
        }

    }

    /**
     * 检测是否有网
     */
    public static boolean isNetworkAvailable(Context context) {
        if (context != null) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
            NetworkInfo info = cm.getActiveNetworkInfo();
            if (info != null) {
                return info.isAvailable();
            }
        }
        return false;
    }
}
