package mvp.module;

import android.text.TextUtils;

import butterknife.internal.Utils;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public abstract class FormUploadRequest extends BaseUploadRequest {

    private String type;
    private UploadByte[] byteList;

    @Override
    protected RequestBody initRequestBody() {
        RequestBody requestBody;

        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM);

        if (params != null && params.size() > 0) {
            for (String key : params.keySet()) {
                builder.addFormDataPart(key, params.get(key));
            }
        }
        buildRequestBody(builder);

        requestBody = builder.build();

        return requestBody;
    }

    protected abstract void buildRequestBody(MultipartBody.Builder builder);

}
