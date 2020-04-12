package mvp.module;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormUploadBuilder extends BaseUploadBuilder<FormUploadBuilder> {
    private List<UploadFile> files = new ArrayList<>();//本地文件集合
    String url=null;
    private String type;//媒体类型
    private List<UploadByte> byteList = new ArrayList<>();//字节流集合
    private Map<String, String> params=new HashMap<>();
    private Map<String, String> headers=new HashMap<>();


    public FormUploadBuilder addFile(String name, String filename, File file) {
        files.add(new UploadFile(name, filename, file));
        return this;
    }


    public FormUploadBuilder addFiles(List<UploadFile> files) {
        this.files = files;
        return this;
    }


    public FormUploadBuilder addByte(String name, String filename, byte[] bytes) {
        byteList.add(new UploadByte(name, filename, bytes));
        return this;
    }


    public FormUploadBuilder addBytes(List<UploadByte> byteList) {
        this.byteList = byteList;
        return this;
    }


    public FormUploadBuilder addType(String type) {
        this.type = type;
        return this;
    }


    public FileUploadRequest fileUploadBuild() {

        return new FileUploadRequest(url, files, params, headers);
    }


    public BytesUploadRequest bytesUploadBuild() {
        return new BytesUploadRequest(url, byteList, type, params, headers);
    }

}
