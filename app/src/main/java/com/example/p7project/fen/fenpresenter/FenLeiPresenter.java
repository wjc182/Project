package com.example.p7project.fen.fenpresenter;

import com.example.p7project.bean.FenLeiBean;
import com.example.p7project.bean.FenLeiRightBean;
import com.example.p7project.fen.contract.FenLeiContract;
import com.example.p7project.fen.model.FenLeiModel;
import com.example.p7project.utils.CallBack;

public class FenLeiPresenter implements FenLeiContract.FenLeiPresenter {
    private final FenLeiModel fenLeiModel;
    private FenLeiContract.FenLeiView fenLeiView;

    public FenLeiPresenter(FenLeiContract.FenLeiView fenLeiView) {
        this.fenLeiView = fenLeiView;
        fenLeiModel = new FenLeiModel();
    }

    @Override
    public void getFenPresenter() {
        fenLeiModel.getFenModel("catalog/index?id=1005000", new CallBack<FenLeiBean>() {
            @Override
            public void OnSuccess(FenLeiBean fenLeiBean) {
                fenLeiView.OkFenLei(fenLeiBean);
            }

            @Override
            public void OnFail(String error) {
                fenLeiView.noFail(error);
            }
        });
    }

    @Override
    public void getFenRightPresenter(int id) {

        fenLeiModel.getFenModel("catalog/current?id="+id, new CallBack<FenLeiRightBean>() {
            @Override
            public void OnSuccess(FenLeiRightBean fenLeiRightBean) {
                fenLeiView.OkFenLeiRight(fenLeiRightBean);
            }

            @Override
            public void OnFail(String error) {

            }
        });
    }
}
