package mvp.module;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

import java.io.IOException;
import java.util.Map;

import butterknife.internal.Utils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.Response;

public abstract class BaseUploadRequest {

    private static final int ERROR = 0;
    private static final int START = 0;
    protected String url;
    protected Map<String, String> params;
    protected Map<String, String> headers;
    private Handler handler;

    public Call upload(final UploadCallback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("UploadCallback can not be null");
        }

        UploadProgressHandler progressHandler = new UploadProgressHandler(callback);
        handler = progressHandler.getHandler();
        handler.sendEmptyMessage(START);

        RequestBody requestBody = initRequestBody();
        requestBody = new ProgressRequestBody(requestBody, handler);

        return OKManager.getInstance().initRequest(url, requestBody, headers, new Callback() {

            private static final int FINISH = 0;

            public void onFailure(Call call, IOException e) {
                Message message = Message.obtain();
                message.what = ERROR;
                message.obj = e.toString();
                handler.sendMessage(message);
            }


            public void onResponse(Call call, Response response) throws IOException {
                if (response != null && response.isSuccessful()) {
                    Message message = Message.obtain();
                    message.what = FINISH;
                    message.obj = response.body().string();
                    handler.sendMessage(message);
                }
            }
        });
    }

    protected abstract RequestBody initRequestBody();
}



