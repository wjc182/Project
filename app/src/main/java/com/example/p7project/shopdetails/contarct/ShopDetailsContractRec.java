package com.example.p7project.shopdetails.contarct;

import com.example.p7project.shopdetails.bean.ShopDetailsBean;
import com.example.p7project.shopdetails.bean.ShopDetailsGpsBean;
import com.example.p7project.utils.CallBack;

public class ShopDetailsContract {
    //商品详情接口
    public interface IDetailsModel{
        //接口
        <T>void getDetailsModel(String url, CallBack<T> callBack);
    }

    public interface IDetailsPresenter{
        void getDetailPresenter(int id);
    }

    public interface IDetailsViews{
        void OnSuccessFDetail(ShopDetailsBean shopDetailsBean);
        void OnSuccessGps(ShopDetailsGpsBean shopDetailsGpsBean);

        void OnFails(String error);
    }
}
