package com.example.p7project.shopdetails.model;

import com.example.p7project.shopdetails.contarct.ShopDetailsTitlesContract;
import com.example.p7project.utils.CallBack;
import com.example.p7project.utils.NetWorkRetrofit;

public class ShopDetailTitleModel implements ShopDetailsTitlesContract.IDetailsModel {

    @Override
    public <T> void getDetailsTitleModel(String url, CallBack<T> callBack) {
        NetWorkRetrofit.getInstance().iModel(url,callBack);
    }
}
