package com.example.p7project.utils;

public interface CallBack <T>{
    void OnSuccess(T t);

    void OnFail(String  error);

}
