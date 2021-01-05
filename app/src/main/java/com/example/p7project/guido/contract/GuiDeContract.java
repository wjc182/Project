package com.example.p7project.guido.contract;

import com.example.p7project.utils.CallBack;

import java.util.HashMap;

public class GuiDeContract {
    public interface GuiModel{
        <T>void getGuiModel(String url, HashMap<String,String> heads, CallBack<T> hCall);

    }
    public interface GuiPresenter{
        void getGuiPresenter();
    }
    public interface GuiView{

        void onSuccess();

        void onFail();

    }
}
