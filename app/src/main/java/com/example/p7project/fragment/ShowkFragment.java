package com.example.p7project.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.p7project.R;
import com.example.p7project.bean.ShouBean;
import com.example.p7project.contract.MainContract;
import com.example.p7project.dapter.SingleLayoutAdapter;
import com.example.p7project.presenter.PresneterImp;

import java.util.ArrayList;
import java.util.List;


public class ShowkFragment extends Fragment implements MainContract.IView {

    private FragmentActivity activity;
    private ArrayList<ShouBean.DataDTO.BannerDTO> bannerDTOS;
    private SingleLayoutAdapter singleLayoutAdapter;
    private RecyclerView rec;
    private SingleLayoutHelper singleLayoutHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_showk, container, false);
        activity = getActivity();
        initView(inflate);
        iniData();
        return inflate;
    }

    private void iniData() {
        PresneterImp presneterImp = new PresneterImp(this);
        presneterImp.Presenter();

    }

    private void initView(View inflate) {
        rec = inflate.findViewById(R.id.rec_show);
        //布局管理
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(activity);
        rec.setLayoutManager(virtualLayoutManager);
        //组件复用
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        rec.setRecycledViewPool(recycledViewPool);
        recycledViewPool.setMaxRecycledViews(0,10);

        //banner通栏布局
        singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(5);// 设置设置布局内每行布局的宽与高的比
        //集合
        bannerDTOS = new ArrayList<>();
        //通栏适配器
        singleLayoutAdapter = new SingleLayoutAdapter(bannerDTOS, activity, singleLayoutHelper);

        //总的适配器
        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager, true);
        //设置适配器
        delegateAdapter.addAdapter(singleLayoutAdapter);
        rec.setAdapter(delegateAdapter);
    }
    //banner
    @Override
    public void Ok(ShouBean shouBean) {

        List<ShouBean.DataDTO.BannerDTO> banner = shouBean.getData().getBanner();
        bannerDTOS.addAll(banner);
        Log.e("aa",bannerDTOS.toString());

        singleLayoutAdapter.notifyDataSetChanged();
    }

    @Override
    public void no(String error) {
        Log.e("TAG",error);
    }
}