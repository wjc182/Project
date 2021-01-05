package com.example;

import android.app.Application;

import com.example.p7project.login.bean.LogBean;
import com.tencent.mmkv.MMKV;

public class Myapp extends Application {
   public static LogBean.DataDTO dataDTO;
   public Myapp myapp;
    @Override
    public void onCreate() {
        super.onCreate();
        this.myapp=this;
        //初始化
        MMKV.initialize(this);
    }
}
