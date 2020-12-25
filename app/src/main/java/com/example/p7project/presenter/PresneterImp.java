package com.example.p7project.presenter;

import com.example.p7project.bean.ShouBean;
import com.example.p7project.contract.MainContract;
import com.example.p7project.model.ModelImp;
import com.example.p7project.utils.CallBack;

public class PresneterImp implements MainContract.IPresenter {
    private final ModelImp modelImp;
    private MainContract.IView iView;

    public PresneterImp(MainContract.IView iView) {
        this.iView = iView;
        modelImp = new ModelImp(this);
    }

    @Override
    public void Presenter() {
        modelImp.Models("api/index", new CallBack<ShouBean>() {
            @Override
            public void OnSuccess(ShouBean shouBean) {
                iView.Ok(shouBean);
            }

            @Override
            public void OnFail(String error) {
                iView.no("网络错误："+error);
            }
        });
    }
}
