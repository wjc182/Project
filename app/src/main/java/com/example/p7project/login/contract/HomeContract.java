package com.example.p7project.login.contract;

import com.example.p7project.utils.CallBack;

import java.util.HashMap;

public class HomeContract {
    public interface IModelHome{
        <T> void getModelTaken(String url, HashMap<String,String> map, CallBack<T> tCallBack);
    }
    public interface IPresenterHome{
        void refreTaken();
    }
    public interface IViewLoginHome{
        void onSuccessTaken();

        void onFailTaken(String error);
    }
}
