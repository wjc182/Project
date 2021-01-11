package com.example.p7project.shopdetails.presenter;

import com.example.p7project.shopdetails.bean.ShopDetailsTitleBean;

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
        shopDetailTitleModel.getDetailsTitleModel("goods/list?categoryId=10050007&page=1&size=100", new CallBack<ShopDetailsTitleBean>() {
            @Override
            public void OnSuccess(ShopDetailsTitleBean shopDetailsTitleBean) {
                iDetailsViews.OnSuccess(shopDetailsTitleBean);
            }

            @Override
            public void OnFail(String error) {
                //错误
                iDetailsViews.OnFail(error);
            }
        });
        
    }
}
