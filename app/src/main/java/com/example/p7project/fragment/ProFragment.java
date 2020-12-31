package com.example.p7project.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.p7project.R;
import com.example.p7project.bean.FenBean;
import com.example.p7project.bean.ShouBean;
import com.example.p7project.contract.MainContract;
import com.example.p7project.dapter.FenAdafel;
import com.example.p7project.presenter.PresneterImp;

import java.util.ArrayList;
import java.util.List;


public class ProFragment extends Fragment implements MainContract.IView{

    private RecyclerView recFen;
    private Button up;
    private Button next;
    private FragmentActivity activity;
    private ArrayList<FenBean.DataDTO.DataDTOs> list;
    private FenAdafel fenAdafel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pro, container, false);
        activity = getActivity();
        initView(view);
        //准备数据
        initData();
        return view;
    }
    //准备数据
    private void initData() {
        PresneterImp presneterImp = new PresneterImp(this);
        presneterImp.Presenter();
    }

    private void initView(View view) {
        recFen=view.findViewById(R.id.rec_fen);
        up=view.findViewById(R.id.up_ye);
        next=view.findViewById(R.id.next_ye);
        //布局管理器
        recFen.setLayoutManager(new LinearLayoutManager(activity));
        //集合
        list = new ArrayList<>();
        //适配器
        fenAdafel = new FenAdafel(activity,list);
        recFen.setAdapter(fenAdafel);
        fenAdafel.setItemListener(new FenAdafel.ItemListener() {
            @Override
            public void itemClick(int pos) {
                Toast.makeText(activity, "专题未做", Toast.LENGTH_SHORT).show();
            }
        });
        //监听
        onListener();
    }

    private void onListener() {
        //上一页
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //下一页
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }

    @Override
    public void Ok(ShouBean shouBean) {

    }

    @Override
    public void OkFen(FenBean fenBean) {
        List<FenBean.DataDTO.DataDTOs> data = fenBean.getData().getData();
        list.addAll(data);
        fenAdafel.notifyDataSetChanged();
    }

    @Override
    public void no(String error) {
    }
}