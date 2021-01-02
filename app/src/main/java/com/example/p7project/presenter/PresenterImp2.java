package com.example.p7project.presenter;

import android.view.View;

import com.example.p7project.bean.FenBean;
import com.example.p7project.contract.MainContract;
import com.example.p7project.model.ModelImp;
import com.example.p7project.utils.CallBack;

public class PresenterImp2 implements MainContract.IPresenter {

    private final ModelImp modelImp;
    private MainContract.IView view;

    public PresenterImp2(MainContract.IView view) {
        this.view = view;
        modelImp = new ModelImp(this);
    }

    @Override
    public void Presenter() {

    }

    @Override
    public void Presenter2() {
        modelImp.Models("list?page=2&size=10", new CallBack<FenBean>() {
            @Override
            public void OnSuccess(FenBean fenBean) {
                view.OkFen(fenBean);
            }

            @Override
            public void OnFail(String error) {

            }
        });
    }
}
