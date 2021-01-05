package com.example.p7project.fen.contract;

import com.example.p7project.bean.FenLeiBean;
import com.example.p7project.bean.FenLeiRightBean;
import com.example.p7project.utils.CallBack;

public class FenLeiContract {
    public interface FenLeiPresenter{
        void getFenPresenter();

        void getFenRightPresenter(int id);


    }
    public interface FenLeiModel{
        <T> void getFenModel(String url,CallBack<T> callBack);
    }
    public interface FenLeiView{
        void OkFenLei(FenLeiBean fenLeiBean);

        void OkFenLeiRight(FenLeiRightBean fenLeiRightBean);

        void noFail(String error);
    }
}
