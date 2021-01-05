package com.example.p7project;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.p7project.guido.contract.GuiDeContract;
import com.example.p7project.guido.presenter.GuiDePresenter;

public class GuiDeActivity extends AppCompatActivity implements GuiDeContract.GuiView {

    private ImageView guiImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui_de);

        initView();
        initData();
    }

    private void initData() {
        //准备数据
        GuiDePresenter guiDePresenter = new GuiDePresenter(this);
        guiDePresenter.getGuiPresenter();
    }

    private void initView() {
        guiImage = (ImageView) findViewById(R.id.gui_image);
        //动画
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(guiImage, View.ROTATION, 0, 720);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimator);
        animatorSet.setDuration(2000);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                onSuccess();
            }
        });
    }

    @Override
    public void onSuccess() {
        //跳转
        startActivity(new Intent(GuiDeActivity.this,HomeActivity.class));
        finish();
    }

    @Override
    public void onFail() {
        Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
    }
}