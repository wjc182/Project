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
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.p7project.R;
import com.example.p7project.bean.ShouBean;
import com.example.p7project.contract.MainContract;
import com.example.p7project.dapter.GridLayoutBrandAdafel;
import com.example.p7project.dapter.GridLayoutHelperAdafel;
import com.example.p7project.dapter.GridLayoutHelperPeson;
import com.example.p7project.dapter.GridLayoutHelperWeek;
import com.example.p7project.dapter.GridLayoutHomeAdafel;
import com.example.p7project.dapter.LinerAdapter;
import com.example.p7project.dapter.LinerAdapterPerson;
import com.example.p7project.dapter.LinerAdapterTopic;
import com.example.p7project.dapter.LinerAdapterTopics;
import com.example.p7project.dapter.LinerHomeAdapter;
import com.example.p7project.dapter.SingleLayoutAdapter;
import com.example.p7project.dapter.WeekAdapter;
import com.example.p7project.presenter.PresneterImp;

import java.util.ArrayList;
import java.util.List;


public class ShowkFragment extends Fragment implements MainContract.IView {

    private FragmentActivity activity;
    private ArrayList<ShouBean.DataDTO.BannerDTO> bannerDTOS;
    private SingleLayoutAdapter singleLayoutAdapter;
    private RecyclerView rec;
    private SingleLayoutHelper singleLayoutHelper;
    private ArrayList<ShouBean.DataDTO.ChannelDTO> channelDTOS;
    private GridLayoutBrandAdafel gridLayoutHelperAdafel;
    private ArrayList<ShouBean.DataDTO.BrandListDTO> brandListDTOS;
    private GridLayoutHelperAdafel gridLayoutHelperAdafel1;
    private LinerAdapter linerAdapter;
    private WeekAdapter weekAdapter;
    private ArrayList<ShouBean.DataDTO.NewGoodsListDTO> newGoodsListDTOS;
    private GridLayoutHelperWeek gridLayoutHelperWeek;
    private ArrayList<ShouBean.DataDTO.HotGoodsListDTO> hotGoodsListDTOS;
    private GridLayoutHelperPeson gridLayoutHelperPeson;
    private LinerAdapterPerson linerAdapterPerson;
    private LinerAdapterTopic linerAdapterTopic;
    private ArrayList<ShouBean.DataDTO.TopicListDTO> topicListDTOS;
    private LinerAdapterTopics topics;
    private LinerHomeAdapter linerHomeAdapter;
    private ArrayList<ShouBean.DataDTO.CategoryListDTO.GoodsListDTO> goodsListDTOS;
    private GridLayoutHomeAdafel gridLayoutHomeAdafel;

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
//        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(5);// 设置设置布局内每行布局的宽与高的比
        //集合
        bannerDTOS = new ArrayList<>();
        //通栏适配器
        singleLayoutAdapter = new SingleLayoutAdapter(bannerDTOS, activity, singleLayoutHelper);
        //配件
        peiJian();
        //品牌制造商提供
        brandTille();
        //商品方法
        brand();
        //天气
        week();
        //周末推荐
        weekOne();
        //人气推荐
        PersonPush();
        //人气
        person();
        topicTitle();
        //专题
        topic();
        //home
        home();
        //居家
       homeImp();
        //总的适配器
        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager);
        //设置适配器
        delegateAdapter.addAdapter(singleLayoutAdapter);
        delegateAdapter.addAdapter(gridLayoutHelperAdafel);
        delegateAdapter.addAdapter(linerAdapter);
        delegateAdapter.addAdapter(gridLayoutHelperAdafel1);
        delegateAdapter.addAdapter(weekAdapter);
        delegateAdapter.addAdapter(gridLayoutHelperWeek);
        delegateAdapter.addAdapter(linerAdapterPerson);
        delegateAdapter.addAdapter(gridLayoutHelperPeson);
        delegateAdapter.addAdapter(linerAdapterTopic);
        delegateAdapter.addAdapter(topics);
        delegateAdapter.addAdapter(linerHomeAdapter);
        delegateAdapter.addAdapter(gridLayoutHomeAdafel);

        rec.setAdapter(delegateAdapter);
    }

    private void homeImp() {
        GridLayoutHelper gridLayoutHelper4 = new GridLayoutHelper(3);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper4.setItemCount(3);// 设置布局里Item个数
        gridLayoutHelper4.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper4.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper4.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper4.setAspectRatio(2.5f);// 设置设置布局内每行布局的宽与高的比
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper4.setWeights(new float[]{50,50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper4.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper4.setHGap(20);// 控制子元素之间的水平间距
        gridLayoutHelper4.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper4.setSpanCount(2);// 设置每行多少个网格
        goodsListDTOS = new ArrayList<>();
        gridLayoutHomeAdafel = new GridLayoutHomeAdafel(activity, goodsListDTOS, gridLayoutHelper4);
    }

    private void home() {
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
        linerHomeAdapter = new LinerHomeAdapter(activity, linearLayoutHelper);
    }

    private void topicTitle() {
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
        linerAdapterTopic = new LinerAdapterTopic(activity, linearLayoutHelper);
    }

    private void topic() {
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
        linearLayoutHelper.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的比
        // linearLayoutHelper特有属性
        linearLayoutHelper.setDividerHeight(1); // 设置每行Item的距离
        topicListDTOS = new ArrayList<>();
        topics = new LinerAdapterTopics(activity, linearLayoutHelper, topicListDTOS);
    }

    private void peiJian() {
        //网格布局
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
        gridLayoutHelper.setAspectRatio(5);// 设置设置布局内每行布局的宽与高的比
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{22,22,22,22,22,22});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(20);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(true);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(6);// 设置每行多少个网格
        channelDTOS = new ArrayList<>();
        gridLayoutHelperAdafel = new GridLayoutBrandAdafel(activity, channelDTOS, gridLayoutHelper);
    }

    private void PersonPush() {
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
        linearLayoutHelper.setAspectRatio(7);// 设置设置布局内每行布局的宽与高的比
        // linearLayoutHelper特有属性
        linearLayoutHelper.setDividerHeight(1); // 设置每行Item的距离
        linerAdapterPerson = new LinerAdapterPerson(activity, linearLayoutHelper);
    }

    private void person() {
        GridLayoutHelper gridLayoutHelper3 = new GridLayoutHelper(3);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper3.setItemCount(4);// 设置布局里Item个数
        gridLayoutHelper3.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper3.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper3.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper3.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的比
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper3.setWeights(new float[]{100});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper3.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper3.setHGap(20);// 控制子元素之间的水平间距
        gridLayoutHelper3.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper3.setSpanCount(1);// 设置每行多少个网格
        hotGoodsListDTOS = new ArrayList<>();
        gridLayoutHelperPeson = new GridLayoutHelperPeson(activity, hotGoodsListDTOS, gridLayoutHelper3);
    }

    private void weekOne() {
        GridLayoutHelper gridLayoutHelper2 = new GridLayoutHelper(3);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper2.setItemCount(3);// 设置布局里Item个数
        gridLayoutHelper2.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper2.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper2.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper2.setAspectRatio(2.5f);// 设置设置布局内每行布局的宽与高的比
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper2.setWeights(new float[]{50,50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper2.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper2.setHGap(20);// 控制子元素之间的水平间距
        gridLayoutHelper2.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper2.setSpanCount(2);// 设置每行多少个网格
        newGoodsListDTOS = new ArrayList<>();
        gridLayoutHelperWeek = new GridLayoutHelperWeek(activity, newGoodsListDTOS, gridLayoutHelper2);
    }

    private void week() {
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
        weekAdapter = new WeekAdapter(activity, linearLayoutHelper);

    }

    private void brandTille() {
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
        linearLayoutHelper.setDividerHeight(3); // 设置每行Item的距离
        linerAdapter = new LinerAdapter(activity, linearLayoutHelper);
    }

    private void brand() {
        GridLayoutHelper gridLayoutHelper1 = new GridLayoutHelper(3);
        // 在构造函数设置每行的网格个数
        // 公共属性
        gridLayoutHelper1.setItemCount(1);// 设置布局里Item个数
        gridLayoutHelper1.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper1.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper1.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper1.setAspectRatio(3);// 设置设置布局内每行布局的宽与高的比
        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper1.setWeights(new float[]{50,50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper1.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper1.setHGap(20);// 控制子元素之间的水平间距
        gridLayoutHelper1.setAutoExpand(true);//是否自动填充空白区域
        gridLayoutHelper1.setSpanCount(2);// 设置每行多少个网格
        brandListDTOS = new ArrayList<>();
        gridLayoutHelperAdafel1 = new GridLayoutHelperAdafel(activity, brandListDTOS, gridLayoutHelper1);

    }

    //banner
    @Override
    public void Ok(ShouBean shouBean) {

        List<ShouBean.DataDTO.BannerDTO> banner = shouBean.getData().getBanner();
        bannerDTOS.addAll(banner);
        singleLayoutAdapter.notifyDataSetChanged();

        List<ShouBean.DataDTO.ChannelDTO> channel = shouBean.getData().getChannel();
        channelDTOS.addAll(channel);
        gridLayoutHelperAdafel.notifyDataSetChanged();

        List<ShouBean.DataDTO.BrandListDTO> brandList = shouBean.getData().getBrandList();
        brandListDTOS.addAll(brandList);
        gridLayoutHelperAdafel1.notifyDataSetChanged();

        List<ShouBean.DataDTO.NewGoodsListDTO> newGoodsList = shouBean.getData().getNewGoodsList();
        newGoodsListDTOS.addAll(newGoodsList);
        gridLayoutHelperWeek.notifyDataSetChanged();

        List<ShouBean.DataDTO.HotGoodsListDTO> hotGoodsList = shouBean.getData().getHotGoodsList();
        hotGoodsListDTOS.addAll(hotGoodsList);
        gridLayoutHelperPeson.notifyDataSetChanged();

        List<ShouBean.DataDTO.TopicListDTO> topicList = shouBean.getData().getTopicList();
        topicListDTOS.addAll(topicList);
        topics.notifyDataSetChanged();

        for (int i = 0; i < shouBean.getData().getCategoryList().size(); i++) {
            List<ShouBean.DataDTO.CategoryListDTO.GoodsListDTO> goodsList = shouBean.getData().getCategoryList().get(i).getGoodsList();
            goodsListDTOS.addAll(goodsList);
        }
        gridLayoutHomeAdafel.notifyDataSetChanged();

    }

    @Override
    public void no(String error) {
        Log.e("TAG",error);
    }
}