package com.example.p7project.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.example.p7project.R;
import com.example.p7project.bean.FenLeiBean;
import com.example.p7project.bean.ShouBean;
import com.example.p7project.bean.ZhuanTiBean;
import com.example.p7project.contract.MainContract;
import com.example.p7project.presenter.PresneterImp;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class FenFragment extends Fragment implements MainContract.IView {

    private FragmentActivity activity;
    private TextView edSou;
    private TabLayout tab_fen;
    private FrameLayout fenFrame;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_fen, container, false);
        activity = getActivity();
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        //准备数据
        PresneterImp presneterImp = new PresneterImp(this);
        presneterImp.Presenter();
    }

    private void initView(View inflate) {
        edSou = inflate.findViewById(R.id.ed_sou);
        tab_fen = inflate.findViewById(R.id.tab_fen);
        fenFrame=inflate.findViewById(R.id.fen_frame);
        //搜索吐司
        edSou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "搜索土司", Toast.LENGTH_SHORT).show();
            }
        });
        RewFragment rewFragment = new RewFragment();
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        supportFragmentManager.beginTransaction()
                .add(R.id.fen_frame,rewFragment)
                .show(rewFragment)
                .commit();
    }

    @Override
    public void Ok(ShouBean shouBean) {

    }

    @Override
    public void OkFen(ZhuanTiBean fenBean) {

    }

    @Override
    public void OkFenLei(FenLeiBean fenLeiBean) {
        for (int i = 0; i < fenLeiBean.getData().getCategoryList().size(); i++) {
            FenLeiBean.DataDTO.CurrentCategoryDTO currentCategory = fenLeiBean.getData().getCurrentCategory();
            RewFragment rewFragment = new RewFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("id", currentCategory.getId());
            //传递id
            rewFragment.setArguments(bundle);

        }
    }

    @Override
    public void no(String error) {

    }
}