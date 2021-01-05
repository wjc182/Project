package com.example.p7project.fen.model;

import com.example.p7project.fen.contract.FenLeiContract;
import com.example.p7project.utils.CallBack;
import com.example.p7project.utils.NetWorkRetrofit;

public class FenLeiModel implements FenLeiContract.FenLeiModel {
    @Override
    public <T> void getFenModel(String url, CallBack<T> callBack) {
        NetWorkRetrofit.getInstance().iModel(url,callBack);
    }
}
