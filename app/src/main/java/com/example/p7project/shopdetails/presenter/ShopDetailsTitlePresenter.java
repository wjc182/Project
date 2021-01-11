package com.example.p7project.shopdetails.presenter;

import com.example.p7project.bean.FenLeiBean;
import com.example.p7project.shopdetails.bean.ShopDetailsBean;
import com.example.p7project.shopdetails.bean.ShopDetailsTitleBean;
import com.example.p7project.shopdetails.contarct.ShopDetailsContract;
import com.example.p7project.shopdetails.contarct.ShopDetailsTitlesContract;
import com.example.p7project.shopdetails.model.ShopDetailModel;
import com.example.p7project.shopdetails.model.ShopDetailTitleModel;
import com.example.p7project.utils.CallBack;

public class ShopDetailsTitlePresenter implements ShopDetailsTitlesContract.IDetailsPresenter {

    private final ShopDetailTitleModel shopDetailTitleModel;
    private ShopDetailsTitlesContract.IDetailsViews iDetailsViews;


    public ShopDetailsTitlePresenter(ShopDetailsTitlesContract.IDetailsViews iDetailsViews) {
        this.iDetailsViews = iDetailsViews;
        shopDetailTitleModel = new ShopDetailTitleModel();
    }

    @Override
    public void getDetailPresenter() {

        shopDetailTitleModel.getDetailsTitleModel("catalog/index?id=1005000", new CallBack<FenLeiBean>() {

            @Override
            public void OnSuccess(FenLeiBean fenLeiBean) {
                iDetailsViews.OnSuccess(fenLeiBean);
            }

            @Override
            public void OnFail(String error) {
                iDetailsViews.OnFail(error);

            }
        });
    }
}
