package com.example.p7project.presenter;

import com.example.p7project.bean.FenLeiBean;
import com.example.p7project.bean.ZhuanTiBean;
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
                view.no("网络错误：" + error);
            }
        });

        modelImp.Models("topic/list?page=1&size=10", new CallBack<ZhuanTiBean>() {
            @Override
            public void OnSuccess(ZhuanTiBean zhuanTiBean) {
                view.OkFen(zhuanTiBean);
            }

            @Override
            public void OnFail(String error) {

            }
        });

        modelImp.Models("catalog/index?id=1005000", new CallBack<FenLeiBean>() {
            @Override
            public void OnSuccess(FenLeiBean fenLeiBean) {
                view.OkFenLei(fenLeiBean);
            }

            @Override
            public void OnFail(String error) {

            }
        });
    }

    @Override
    public void Presenter2() {

    }
}

