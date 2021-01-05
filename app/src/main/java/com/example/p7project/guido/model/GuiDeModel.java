package com.example.p7project.guido.model;

import com.example.p7project.guido.contract.GuiDeContract;
import com.example.p7project.utils.CallBack;
import com.example.p7project.utils.NetWorkRetrofit;

import java.util.HashMap;

public class GuiDeModel implements GuiDeContract.GuiModel{
private GuiDeContract.GuiPresenter presenter;

    public GuiDeModel(GuiDeContract.GuiPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public <T> void getGuiModel(String url, HashMap<String, String> heads, CallBack<T> hCall) {
        NetWorkRetrofit.getInstance().refreshtoken(url,heads,hCall);
    }
}
