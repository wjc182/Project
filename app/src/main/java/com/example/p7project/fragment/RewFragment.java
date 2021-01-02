package com.example.p7project.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.p7project.R;
import com.example.p7project.bean.FenLeiBean;
import com.example.p7project.bean.ShouBean;
import com.example.p7project.bean.ZhuanTiBean;
import com.example.p7project.contract.MainContract;
import com.example.p7project.dapter.GridLayoutBrandAdafel;
import com.example.p7project.dapter.LinerAdapterTopic;
import com.example.p7project.dapter.SingleLayoutAdapter;
import com.example.p7project.fendapter.GridLayoutFenAdafel;
import com.example.p7project.fendapter.LinerAdapterFenTitle;
import com.example.p7project.fendapter.SingleLayoutAdapterFenLei;
import com.example.p7project.presenter.PresneterImp;

import java.util.ArrayList;
import java.util.List;


public class RewFragment extends Fragment implements MainContract.IView {

    private FragmentActivity activity;
    private RecyclerView recyclerView;
    private RecyclerView.RecycledViewPool recycledViewPool;
    private SingleLayoutHelper singleLayoutHelper;
    private ArrayList<FenLeiBean.DataDTO.CategoryListDTO> listBanner;
    private SingleLayoutAdapterFenLei singleLayoutAdapterFenLei;
    private LinerAdapterFenTitle linerAdapterFenTitle;
    private ArrayList<FenLeiBean.DataDTO.CurrentCategoryDTO.SubCategoryListDTO> subCategoryListDTOS;
    private GridLayoutFenAdafel gridLayoutFenAdafel;
    private int id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_rew, container, false);

//        Bundle arguments = getArguments();
//        id = arguments.getInt("id");

        activity = getActivity();
        initView(inflate);
        initData();
        onListener();
        return inflate;
    }
    //监听事件的方法
    private void onListener() {
        singleLayoutAdapterFenLei.setItemListener(new SingleLayoutAdapterFenLei.ItemListener() {
            @Override
            public void itemClick(int pos) {
                Toast.makeText(activity, "点击事件", Toast.LENGTH_SHORT).show();
            }
        });
        gridLayoutFenAdafel.setItemListener(new GridLayoutFenAdafel.ItemListener() {
            @Override
            public void itemClick(int pos) {
                Toast.makeText(activity, "点击事件1", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        //准备数据
        PresneterImp presneterImp = new PresneterImp(this);
        presneterImp.Presenter();
    }

    private void initView(View inflate) {
        recyclerView=inflate.findViewById(R.id.rew_rew_fragment);
        //v_layout布局
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(activity);
        //设置布局
        recyclerView.setLayoutManager(virtualLayoutManager);
        //组件复用
        recycledViewPool = new RecyclerView.RecycledViewPool();
        recyclerView.setRecycledViewPool(recycledViewPool);
        recycledViewPool.setMaxRecycledViews(0,10);
        //banner布局
        bannerManner();
        //线性标题布局
        initTitel();
        //网格布局
        gridManner();
        //总的适配器
        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager);
        //绑定适配器
        delegateAdapter.addAdapter(singleLayoutAdapterFenLei);
        delegateAdapter.addAdapter(linerAdapterFenTitle);
        delegateAdapter.addAdapter(gridLayoutFenAdafel);
        //设置适配器
        recyclerView.setAdapter(delegateAdapter);
    }

    private void initTitel() {
        /**
         设置线性布局
         */
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        // 创建对应的LayoutHelper对象
        // 所有布局的公共属性（属性会在下面详细说明）
        linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        linearLayoutHelper.setPadding(10,10,10,10);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        linearLayoutHelper.setMargin(10,10,10,10);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        linearLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        linearLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        // linearLayoutHelper特有属性
        linearLayoutHelper.setDividerHeight(1); // 设置每行Item的距离
        linerAdapterFenTitle = new LinerAdapterFenTitle(activity, linearLayoutHelper);
    }

    private void gridManner() {
        //网格
        /**
         设置Grid布局
         */
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(3);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper.setItemCount(1);// 设置布局里Item个数
        gridLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的比
//        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{33,33,33});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(20);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(true);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(3);// 设置每行多少个网格
        subCategoryListDTOS = new ArrayList<>();
        gridLayoutFenAdafel = new GridLayoutFenAdafel(activity, subCategoryListDTOS, gridLayoutHelper);
    }

    private void bannerManner() {
        //banner通栏布局
        singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(5);// 设置设置布局内每行布局的宽与高的比
        //集合
        listBanner = new ArrayList<>();
        //通栏适配器
        singleLayoutAdapterFenLei = new SingleLayoutAdapterFenLei(listBanner, activity, singleLayoutHelper);

    }

    @Override
    public void Ok(ShouBean shouBean) {

    }

    @Override
    public void OkFen(ZhuanTiBean fenBean) {

    }

    @Override
    public void OkFenLei(FenLeiBean fenLeiBean) {
        List<FenLeiBean.DataDTO.CategoryListDTO> subCategoryList = fenLeiBean.getData().getCategoryList();
        listBanner.addAll(subCategoryList);
        singleLayoutAdapterFenLei.notifyDataSetChanged();

        List<FenLeiBean.DataDTO.CurrentCategoryDTO.SubCategoryListDTO> subCategoryList1 = fenLeiBean.getData().getCurrentCategory().getSubCategoryList();
        subCategoryListDTOS.addAll(subCategoryList1);
        gridLayoutFenAdafel.notifyDataSetChanged();
    }

    @Override
    public void no(String error) {

    }
}