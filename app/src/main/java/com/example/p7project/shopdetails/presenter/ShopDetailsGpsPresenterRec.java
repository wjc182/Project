package com.example.p7project.shopdetails.presenter;

import com.example.p7project.shopdetails.bean.ShopDetailsBean;
import com.example.p7project.shopdetails.bean.ShopDetailsGpsBean;
import com.example.p7project.shopdetails.bean.ShopDetailsTitleBean;
import com.example.p7project.shopdetails.contarct.ShopDetailsContract;
import com.example.p7project.shopdetails.contarct.ShopDetailsTitlesContract;
import com.example.p7project.shopdetails.model.ShopDetailModel;
import com.example.p7project.shopdetails.model.ShopDetailTitleModel;
import com.example.p7project.utils.CallBack;

public class ShopDetailsGpsPresenter implements  ShopDetailsContract.IDetailsPresenter {

    private final ShopDetailModel detailModel;
    private ShopDetailsContract.IDetailsViews iDetailsViews;

    public ShopDetailsGpsPresenter(ShopDetailsContract.IDetailsViews iDetailsViews) {
        this.iDetailsViews = iDetailsViews;
        detailModel = new ShopDetailModel();
    }

    @Override
    public void getDetailPresenter(int id) {
        detailModel.getDetailsModel("goods/category?id=" + id, new CallBack<ShopDetailsGpsBean>() {
            @Override
            public void OnSuccess(ShopDetailsGpsBean shopDetailsGpsBean) {
                iDetailsViews.OnSuccessGps(shopDetailsGpsBean);
            }

            @Override
            public void OnFail(String error) {
                iDetailsViews.OnFails(error);
            }

        });
        detailModel.getDetailsModel("goods/list?id="+id+"&page=1&size=100", new CallBack<ShopDetailsBean>() {

            @Override
            public void OnSuccess(ShopDetailsBean shopDetailsBean) {
                iDetailsViews.OnSuccessFDetail(shopDetailsBean);
            }

            @Override
            public void OnFail(String error) {
                iDetailsViews.OnFails(error);
            }

        });

    }
}
