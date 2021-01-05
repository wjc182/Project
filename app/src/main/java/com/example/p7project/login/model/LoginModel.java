package com.example.p7project.login.model;

import com.example.p7project.login.contract.LoginContract;
import com.example.p7project.utils.CallBack;
import com.example.p7project.utils.NetWorkRetrofit;

import java.util.HashMap;

public class LoginModel implements LoginContract.IModelLogin{
    private LoginContract.IPresenter iPresenter;

    public LoginModel(LoginContract.IPresenter iPresenter) {
        this.iPresenter = iPresenter;
    }

    @Override
    public <T> void getModel(String url, HashMap<String, String> map, CallBack<T> tCallBack) {

        NetWorkRetrofit.getInstance().iModelLog(url,map,tCallBack);
    }
}
