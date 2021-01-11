package com.example.p7project;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.p7project.bean.FenLeiBean;
import com.example.p7project.bean.ShouBean;
import com.example.p7project.shopdetails.adapter.ViewPagerAdafel;
import com.example.p7project.shopdetails.contarct.ShopDetailsTitlesContract;
import com.example.p7project.shopdetails.fragment.RecDetailFragment;
import com.example.p7project.shopdetails.presenter.ShopDetailsTitlePresenter;
import com.google.android.material.tabs.TabLayout;

import java.io.Serializable;
import java.util.ArrayList;

public class ShopDetailsActivity extends AppCompatActivity implements ShopDetailsTitlesContract.IDetailsViews {

    private TabLayout tabShopTitle;
    private ViewPager tabShopView;

    private ArrayList<Fragment> fragments;
    private Integer id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_main);
        initView();
    }


    private void initView() {
        tabShopTitle = (TabLayout) findViewById(R.id.tab_shop_title);
        tabShopView = (ViewPager) findViewById(R.id.tab_shop_vap);
        Intent intent = getIntent();
        ShouBean.DataDTO.ChannelDTO list = (ShouBean.DataDTO.ChannelDTO) intent.getSerializableExtra("list");
        id = list.getId();
        //商品详情页
        fragments = new ArrayList<>();
        initData();
    }

    private void initData() {
        ShopDetailsTitlePresenter shopDetailsTitlePresenter = new ShopDetailsTitlePresenter(this);
        shopDetailsTitlePresenter.getDetailPresenter(id);
    }


    @Override
    public void OnSuccess(FenLeiBean shopDetailsTitleBean) {
        for (int i = 0; i < shopDetailsTitleBean.getData().getCategoryList().size(); i++) {
            RecDetailFragment recDetailFragment = new RecDetailFragment();
            //传id嵌套使用
            Bundle bundle = new Bundle();
            int id = shopDetailsTitleBean.getData().getCategoryList().get(i).getId();
            bundle.putInt("id",id);
            fragments.add(recDetailFragment);
            recDetailFragment.setArguments(bundle);
        }
        ViewPagerAdafel viewPagerAdafel = new ViewPagerAdafel(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,fragments);
        //嵌套绑定viewpager
        tabShopView.setAdapter(viewPagerAdafel);
        tabShopTitle.setupWithViewPager(tabShopView);

        for (int i = 0; i < shopDetailsTitleBean.getData().getCategoryList().size(); i++) {
            tabShopTitle.getTabAt(i).setText(shopDetailsTitleBean.getData().getCategoryList().get(i).getName());
        }
    }

    @Override
    public void OnFail(String error) {

    }
}