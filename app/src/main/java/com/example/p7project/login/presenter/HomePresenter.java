package com.example.p7project.login.presenter;

import android.util.Log;
import android.widget.Toast;

import com.example.p7project.login.bean.LogBean;
import com.example.p7project.login.bean.TokenBean;
import com.example.p7project.login.contract.HomeContract;
import com.example.p7project.login.model.HomeModel;
import com.example.p7project.utils.CallBack;
import com.tencent.mmkv.MMKV;

import java.util.HashMap;

public class HomePresenter implements HomeContract.IPresenterHome {
    private final HomeModel homeModel;
    private HomeContract.IViewLoginHome iViewLoginHome;

    public HomePresenter(HomeContract.IViewLoginHome iViewLoginHome) {
        this.iViewLoginHome = iViewLoginHome;
        homeModel = new HomeModel(this);

    }

    @Override
    public void refreTaken() {
        MMKV mmkv = MMKV.defaultMMKV();

       LogBean.DataDTO taken = mmkv.decodeParcelable("logInfor", LogBean.DataDTO.class);

       if(taken!=null){
           if (taken.getToken() == null && taken.getToken().length() > 0) {
               //刷新
               HashMap<String, String> heads = new HashMap<>();

               heads.put("X-Nideshop-Token",taken.getToken());

               homeModel.getModelTaken("auth/refreshToken", heads, new CallBack<TokenBean>() {
                   @Override
                   public void OnSuccess(TokenBean tokenBean) {
                       if(tokenBean.getErrno()==0){
                           taken.setToken(tokenBean.getData());
                           mmkv.encode("logInfor",taken);
                       }
                   }
                   @Override
                   public void OnFail(String error) {
                       iViewLoginHome.onFailTaken(error);
                   }
               });
           }
       }
    }
}
