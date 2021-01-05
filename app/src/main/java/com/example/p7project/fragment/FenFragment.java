package com.example.p7project.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.example.p7project.R;
import com.example.p7project.bean.FenLeiBean;
import com.example.p7project.bean.FenLeiRightBean;
import com.example.p7project.fen.contract.FenLeiContract;
import com.example.p7project.fen.fenpresenter.FenLeiPresenter;
import com.example.p7project.fenadafel.FenLeftRecAdafel;
import com.example.p7project.fenadafel.FenRightRecAdafel;
import com.example.p7project.fenadafel.RewRightAdafel;

import java.util.ArrayList;
import java.util.List;


public class FenFragment extends Fragment implements FenLeiContract.FenLeiView {


    private RecyclerView rewLeft;
    private RecyclerView rewRight;
    private FragmentActivity activity;
    private ArrayList<FenLeiBean.DataDTO.CategoryListDTO> leftList;
    private FenLeftRecAdafel fenLeftRecAddafel;
    private ArrayList<FenLeiRightBean.DataDTO> rightItem;
    private FenRightRecAdafel fenRightRecAdafel;
    private FenLeiPresenter fenLeiPresenter;
    private RecyclerView.RecycledViewPool viewPool;
    private ArrayList<FenLeiRightBean.DataDTO.CurrentCategoryDTO.SubCategoryListDTO> sub;
    private RewRightAdafel rewRightAdafel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_fen, container, false);
        activity = getActivity();
        initView(inflate);
        initData();
        //监听事件
        onListener();
        return inflate;
    }

    private void onListener() {

        fenLeftRecAddafel.setItemListener(new FenLeftRecAdafel.ItemListener() {
            @Override
            public void itemClick(int pos) {
                //当条目未点击时
                if(!leftList.get(pos).isCheck()){
                    //循环把所有未点击变为false
                    for (int i = 0; i < leftList.size(); i++) {
                        leftList.get(pos).setCheck(false);
                    }
                }
                //当点击时变为true
                leftList.get(pos).setCheck(true);
                //刷新适配器
                fenLeftRecAddafel.notifyDataSetChanged();
                //右边联动
                fenLeiPresenter.getFenRightPresenter(leftList.get(pos).getId());
            }
        });
    }

    private void initData() {
        //准备数据
        fenLeiPresenter = new FenLeiPresenter(this);
        fenLeiPresenter.getFenPresenter();
    }

    private void initView(View inflate) {
        rewLeft =inflate.findViewById(R.id.rew_left);
        rewLeft.setLayoutManager(new LinearLayoutManager(activity));
        leftList = new ArrayList<>();
        fenLeftRecAddafel = new FenLeftRecAdafel(activity, leftList);
        rewLeft.setAdapter(fenLeftRecAddafel);

        //右边布局
        rewRight = inflate.findViewById(R.id.rew_right);
//        //布局管理
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(activity);
        //组件复用
        viewPool = new RecyclerView.RecycledViewPool();
        rewRight.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0,10);
        //总的适配器
        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager);
        //数据
       rightImp();
       //网格布局
       rightGrid();
        //添加适配器
        delegateAdapter.addAdapter(fenRightRecAdafel);
        delegateAdapter.addAdapter(rewRightAdafel);
        //设置适配器
        rewRight.setLayoutManager(virtualLayoutManager);
        rewRight.setAdapter(delegateAdapter);
    }

    private void rightGrid() {
        GridLayoutHelper gridLayoutHelper4 = new GridLayoutHelper(1);
        // 在构造函数设置每行的网格个数
        gridLayoutHelper4.setSpanCount(3);// 设置每行多少个网格

        gridLayoutHelper4.setBgColor(Color.WHITE);// 设置背景颜色
        sub = new ArrayList<>();
        rewRightAdafel = new RewRightAdafel(activity, sub, gridLayoutHelper4);
    }


    private void rightImp() {
        GridLayoutHelper gridLayoutHelper4 = new GridLayoutHelper(1);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper4.setItemCount(1);// 设置布局里Item个数

        gridLayoutHelper4.setBgColor(Color.WHITE);// 设置背景颜色
        rightItem = new ArrayList<>();
        fenRightRecAdafel = new FenRightRecAdafel(activity,rightItem,gridLayoutHelper4);

    }

    @Override
    public void OkFenLei(FenLeiBean fenLeiBean) {
        List<FenLeiBean.DataDTO.CategoryListDTO> categoryList = fenLeiBean.getData().getCategoryList();
        leftList.addAll(categoryList);
        //默认设置第一条数据，默认选中
        leftList.get(0).setCheck(true);
        fenLeiPresenter.getFenRightPresenter(leftList.get(0).getId());
        //刷新适配器
        fenLeftRecAddafel.notifyDataSetChanged();
    }

    @Override
    public void OkFenLeiRight(FenLeiRightBean fenLeiRightBean) {
        //右边布局
        rightItem.clear();
        sub.clear();
        FenLeiRightBean.DataDTO dataDTO= fenLeiRightBean.getData();

        rightItem.add(dataDTO);

        //刷新适配器
        fenRightRecAdafel.notifyDataSetChanged();
        List<FenLeiRightBean.DataDTO.CurrentCategoryDTO.SubCategoryListDTO> subCategoryList = fenLeiRightBean.getData().getCurrentCategory().getSubCategoryList();
        sub.addAll(subCategoryList);
        rewRightAdafel.notifyDataSetChanged();
    }

    @Override
    public void noFail(String error) {

    }
}