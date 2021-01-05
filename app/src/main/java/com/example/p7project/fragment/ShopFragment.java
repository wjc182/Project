package com.example.p7project.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.p7project.R;


public class ShopFragment extends Fragment {

    private RecyclerView shopCarRec;
    private CheckBox shopCarCheck;
    private TextView shopCarWrite;
    private Button shopCarBuy;
    private FragmentActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_shop, container, false);
        activity = getActivity();
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        shopCarRec = inflate.findViewById(R.id.shop_car_rec);
        shopCarCheck = inflate.findViewById(R.id.shop_car_check_all);
        shopCarWrite = inflate. findViewById(R.id.shop_car_write);
        shopCarBuy = inflate. findViewById(R.id.shop_car_buy);
        //列表布局管理器
        shopCarRec.setLayoutManager(new LinearLayoutManager(activity));
        //集合

        //适配器

        //设置适配器


    }
}