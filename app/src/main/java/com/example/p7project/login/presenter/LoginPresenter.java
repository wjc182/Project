package com.example.p7project.login.presenter;

import com.example.Myapp;
import com.example.p7project.login.bean.LogBean;
import com.example.p7project.login.contract.LoginContract;
import com.example.p7project.login.model.LoginModel;
import com.example.p7project.utils.CallBack;
import com.tencent.mmkv.MMKV;

import java.util.HashMap;

public class LoginPresenter implements LoginContract.IPresenter {
 private LoginContract.IViewLogin iViewLogin;
    private final LoginModel modelLogin;

    public LoginPresenter(LoginContract.IViewLogin iViewLogin) {
        this.iViewLogin = iViewLogin;
        modelLogin = new LoginModel(this);

    }

    @Override
    public void getPresenter(String name, String pass,boolean isSave) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("username",name);
        hashMap.put("password",pass);
        modelLogin.getModel("auth/login", hashMap,new CallBack<LogBean>() {
            @Override
            public void OnSuccess(LogBean logBean) {
                //请求码正确
                if(logBean.getData().getCode()==200){
                    MMKV mmkv = MMKV.defaultMMKV();
                    if(isSave){
                        //保存
                        mmkv.encode("logInfor",logBean.getData());

                    }else {
                        //不保存
                        mmkv.removeValueForKey("logInfor");
                    }
                    //调用初始化方法工具类
                  Myapp.dataDTO=logBean.getData();
                    //成功的方法
                    iViewLogin.onSuccess();
                }
            }
            @Override
            public void OnFail(String error) {
                iViewLogin.onFail(error);
            }
        });
    }
}
