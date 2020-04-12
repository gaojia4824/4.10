package mvp.module;

public interface UploadCallback extends FileCallback {
    void onStart();

    void onProgress(long currentSize, long totalSize, float progress);

    void onFinish(String response);

    void onError(String error);
}