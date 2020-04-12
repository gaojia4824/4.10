package mvp.module.rx;

import android.util.Log;

import java.io.IOException;

import base.ApiService;
import callback.IDataCallBack;
import entity.ChaptersListInfo;
import mvp.module.OKManager;
import okhttp3.ResponseBody;
import util.GsonUtil;
public class RxImpl {
    private  ApiService mApiService;

    public RxImpl(){
        mApiService = OKManager.getInstance().apiService();
    }
    public void getChaptersList(String url, final IDataCallBack callBack){
        mApiService.getData(url).compose(RxSchdules.<ResponseBody>io_main()).
                subscribe(new RxObserver<ResponseBody>(callBack) {
                    @Override
                    public void onNext(ResponseBody value) {
                        try {
                            String jsonStr = value.string();
                            Log.e("TAG",jsonStr+"=111111=");
                            ChaptersListInfo chaptersListInfo = GsonUtil.jsonStrToBean(jsonStr, ChaptersListInfo.class);
                            callBack.onResponseData(chaptersListInfo);
                        } catch (IOException e) {
                            Log.e("TAG","=onFaile=");
                            e.printStackTrace();
                            callBack.onFaileData(e.getMessage());
                        }
                    }
                });
    }
}
