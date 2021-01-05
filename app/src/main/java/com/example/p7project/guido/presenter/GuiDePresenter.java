package com.example.p7project.guido.presenter;

import android.text.TextUtils;

import com.example.p7project.guido.contract.GuiDeContract;
import com.example.p7project.guido.model.GuiDeModel;
import com.example.p7project.login.bean.LogBean;
import com.example.p7project.login.bean.TokenBean;
import com.example.p7project.utils.CallBack;
import com.tencent.mmkv.MMKV;

import java.util.HashMap;

public class GuiDePresenter implements GuiDeContract.GuiPresenter{
    private final GuiDeModel guiDeModel;
    private GuiDeContract.GuiView guiView;

    public GuiDePresenter(GuiDeContract.GuiView guiView) {
        this.guiView = guiView;
        guiDeModel = new GuiDeModel(this);
    }

    @Override
    public void getGuiPresenter() {
        MMKV mmkv = MMKV.defaultMMKV();

        if (!TextUtils.isEmpty(mmkv.decodeString("token"))) {

            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("X-Nideshop-Token", mmkv.decodeString("token"));

            guiDeModel.getGuiModel("auth/refreshT2oken", hashMap, new CallBack<TokenBean>() {
                @Override
                public void OnSuccess(TokenBean tokenBean) {
                    mmkv.encode("token", tokenBean.getData());
                }

                @Override
                public void OnFail(String error) {

                }
            });
        }
    }
}
