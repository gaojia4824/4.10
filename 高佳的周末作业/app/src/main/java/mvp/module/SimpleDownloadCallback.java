package mvp.module;

import java.io.File;

public abstract class SimpleDownloadCallback implements DownloadCallback {


    public void onStart(long currentSize, long totalSize, float progress) {

    }


    public void onProgress(long currentSize, long totalSize, float progress) {

    }


    public void onPause() {

    }


    public void onCancel() {

    }


    public void onFinish(File file) {

    }


    public void onWait() {

    }


    public void onError(String error) {

    }
}
