package com.example.p7project.login.contract;

import com.example.p7project.login.bean.LogBean;
import com.example.p7project.utils.CallBack;

import java.util.HashMap;

public class LoginContract {
    public interface IModelLogin{

        <T> void getModel(String url, HashMap<String,String> heads, CallBack<T> tCallBack);
    }
    public interface IPresenter{
        void getPresenter(String name,String pass,boolean isSave);
    }
    public interface IViewLogin{

        void onSuccess();

        void onFail(String error);
    }
}
