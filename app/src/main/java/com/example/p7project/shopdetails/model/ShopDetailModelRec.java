package com.example.p7project.shopdetails.model;

import com.example.p7project.shopdetails.contarct.ShopDetailsContract;
import com.example.p7project.utils.CallBack;
import com.example.p7project.utils.NetWorkRetrofit;

public class ShopDetailModel implements ShopDetailsContract.IDetailsModel {

    @Override
    public <T> void getDetailsModel(String url, CallBack<T> callBack) {

        NetWorkRetrofit.getInstance().iModel(url,callBack);
    }
}
