package com.example.p7project.model;

import com.example.p7project.contract.MainContract;
import com.example.p7project.utils.CallBack;
import com.example.p7project.utils.NextRetrofit;

public class ModelImp implements MainContract.IModel {
    private MainContract.IPresenter presenter;

    public ModelImp(MainContract.IPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public <T> void Models(String string, CallBack<T> callBack) {
        NextRetrofit.getInstance().iModel(string,callBack);
    }
}
