package com.example.p7project;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.p7project.fragment.FenFragment;
import com.example.p7project.fragment.MeFragment;
import com.example.p7project.fragment.ProFragment;
import com.example.p7project.fragment.ShopFragment;
import com.example.p7project.fragment.ShowkFragment;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frame;
    private RadioButton ShouYe;
    private RadioButton proFess;
    private RadioButton Choose;
    private RadioButton ShowCar;
    private RadioButton Me;
    private RadioGroup radioGroup;
    private FragmentManager supportFragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        frame = (FrameLayout) findViewById(R.id.frame);
        ShouYe = (RadioButton) findViewById(R.id.Shou_ye);
        proFess = (RadioButton) findViewById(R.id.pro_fess);
        Choose = (RadioButton) findViewById(R.id.Choose);
        ShowCar = (RadioButton) findViewById(R.id.Show_Car);

        Me = (RadioButton) findViewById(R.id.Me);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        ShowkFragment showkFragment = new ShowkFragment();
        ProFragment proFragment = new ProFragment();
        FenFragment fenFragment = new FenFragment();
        ShopFragment shopFragment = new ShopFragment();
        MeFragment meFragment = new MeFragment();
        //事物
        supportFragmentManager = getSupportFragmentManager();

        supportFragmentManager.beginTransaction()
                .add(R.id.frame, showkFragment)
                .add(R.id.frame, fenFragment)
                .add(R.id.frame, proFragment)
                .add(R.id.frame, shopFragment)
                .add(R.id.frame, meFragment)
                .show(shopFragment)
                .hide(fenFragment)
                .hide(proFragment)
                .hide(shopFragment)
                .hide(meFragment)
                .commit();


        //默认选择首页
        radioGroup.check(R.id.Shou_ye);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.Shou_ye:
                        supportFragmentManager.beginTransaction()
                                .hide(shopFragment)
                                .hide(fenFragment)
                                .hide(proFragment)
                                .show(showkFragment)
                                .hide(meFragment)
                                .commit();
                        break;
                    case R.id.pro_fess:
                        supportFragmentManager.beginTransaction()
                                .hide(shopFragment)
                                .hide(fenFragment)
                                .show(proFragment)
                                .hide(showkFragment)
                                .hide(meFragment)
                                .commit();
                        break;

                    case R.id.Choose:
                        supportFragmentManager.beginTransaction()
                                .hide(shopFragment)
                                .show(fenFragment)
                                .hide(proFragment)
                                .hide(showkFragment)
                                .hide(meFragment)
                                .commit();
                        break;
                    case R.id.Show_Car:
                        supportFragmentManager.beginTransaction()
                                .hide(showkFragment)
                                .hide(fenFragment)
                                .hide(proFragment)
                                .show(shopFragment)
                                .hide(meFragment)
                                .commit();
                        break;

                    case R.id.Me:
                        supportFragmentManager.beginTransaction()
                                .hide(shopFragment)
                                .hide(fenFragment)
                                .hide(proFragment)
                                .hide(showkFragment)
                                .show(meFragment)
                                .commit();
                        break;
                }
            }
        });

    }
}