package mvp.module;

import android.os.Handler;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

class ProgressRequestBody extends RequestBody {
    public ProgressRequestBody(RequestBody requestBody, Handler handler) {

    }


    @Override
    public MediaType contentType() {
        return null;
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {

    }
}
