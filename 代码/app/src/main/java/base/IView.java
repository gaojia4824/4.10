package base;

public interface IView<T> {
    void onScuess(T t);
    void onFaile(String msg);
}
