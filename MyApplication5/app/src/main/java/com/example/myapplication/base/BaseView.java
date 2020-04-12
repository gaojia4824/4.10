package com.example.myapplication.base;


//  view  的接口
public interface BaseView<T> {
    void getSucceed(T t);

    void getError(String str);
}
