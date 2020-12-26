package com.example.p7project.presenter;

import com.example.p7project.bean.ShouBean;
import com.example.p7project.contract.MainContract;
import com.example.p7project.model.ModelImp;
import com.example.p7project.utils.CallBack;

public class PresneterImp implements MainContract.IPresenter {

    private final ModelImp modelImp;
    private MainContract.IView view;

    public PresneterImp(MainContract.IView view) {
        this.view = view;
        modelImp = new ModelImp(this);
    }

    @Override
    public void Presenter() {
        modelImp.Models("api/index", new CallBack<ShouBean>() {
            @Override
            public void OnSuccess(ShouBean shouBean) {
                view.Ok(shouBean);
            }

            @Override
            public void OnFail(String error) {
                view.no("网络错误："+error);
            }
        });
    }
}
