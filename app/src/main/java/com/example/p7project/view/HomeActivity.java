package com.example.p7project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.p7project.login.contract.HomeContract;
import com.example.p7project.login.presenter.HomePresenter;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HomeActivity extends AppCompatActivity implements HomeContract.IViewLoginHome {

    private TextView textTimer;
    private Disposable subscribe;
    private HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initData();
    }

    private void initData() {
        //准备数据
        homePresenter = new HomePresenter(this);
       homePresenter.refreTaken();

    }

    private void initView() {
        textTimer = (TextView) findViewById(R.id.text_timer);
        subscribe = Observable.interval(0, 1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        int id = 3;
                        textTimer.setText((id - aLong) + "s");
                        if(aLong>=3){
                           subscribe.dispose();
                            onSuccessTaken();
                        }
                    }
                });
    }

    @Override
    public void onSuccessTaken() {
        startActivity(new Intent(HomeActivity.this,MainActivity.class));
        finish();
    }

    @Override
    public void onFailTaken(String error) {
        Log.e("TAG",error);
    }
}