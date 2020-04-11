package mvp.module;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import base.ApiService;
import constents.Constants;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import util.LoggingInterceptor;
import util.MyCacheinterceptor;
import util.TrustAllCerts;

//封装网络请求框架
public class OKManager {
    private static volatile OKManager manager;
    private Retrofit rf;
    private OKManager(){
        initOk();
    }

    private void initOk() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(8, TimeUnit.SECONDS);
        builder.readTimeout(8,TimeUnit.SECONDS);

        builder.addNetworkInterceptor(new LoggingInterceptor());
        builder.addInterceptor(new MyCacheinterceptor());
        builder.sslSocketFactory(createSSLSocketFactory());
        builder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });
        rf=new Retrofit.Builder().client(builder.build())
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


    private SSLSocketFactory createSSLSocketFactory() {
        SSLSocketFactory ssfFactory = null;

        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[]{new TrustAllCerts()}, new SecureRandom());

            ssfFactory = sc.getSocketFactory();
        } catch (Exception e) {
        }

        return ssfFactory;
    }
    public static OKManager getInstance(){
        if (manager==null){
            synchronized (OKManager.class){
                synchronized (OKManager.class){
                    manager=new OKManager();
                }
            }
        }
        return manager;
    }
    public ApiService apiService(){
        if (rf!=null){
            return rf.create(ApiService.class);
        }
        return null;
    }
}
