package util;

import com.google.gson.Gson;

public class GsonUtil {
    static Gson gson;
    static {
        gson=new Gson();
    }
    public static <T> T jsonStrToBean(String jsonStr, Class<T> clazz) {
        return gson.fromJson(jsonStr, clazz);
    }
}
