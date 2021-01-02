package com.example.p7project.contract;


import com.example.p7project.bean.FenBean;
import com.example.p7project.bean.ShouBean;
import com.example.p7project.utils.CallBack;

public class MainContract {
    public interface IModel  {
        <T> void Models(String string,CallBack<T> callBack);
    }
    public interface IPresenter{
        void Presenter();
        
        void Presenter2();
    }
    public interface IView  {
        void Ok(ShouBean shouBean);

        void OkFen(FenBean fenBean);

        void no(String error);
    }
}
