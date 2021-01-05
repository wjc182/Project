package com.example.p7project.login.model;

import com.example.p7project.login.contract.HomeContract;
import com.example.p7project.utils.CallBack;
import com.example.p7project.utils.NetWorkRetrofit;

import java.util.HashMap;

public class HomeModel implements HomeContract.IModelHome {

    private HomeContract.IPresenterHome presenterHome;

    public HomeModel(HomeContract.IPresenterHome presenterHome) {
        this.presenterHome = presenterHome;
    }

    @Override
    public <T> void getModelTaken(String url,HashMap<String,String> map, CallBack<T> tCallBack) {
        NetWorkRetrofit.getInstance().refreshtoken(url,map,tCallBack);
    }
}
