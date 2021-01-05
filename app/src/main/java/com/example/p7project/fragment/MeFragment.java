package com.example.p7project.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.p7project.MainActivity;
import com.example.p7project.R;
import com.example.p7project.login.contract.LoginContract;
import com.example.p7project.login.presenter.LoginPresenter;


public class MeFragment extends Fragment implements LoginContract.IViewLogin {


    private FragmentActivity activity;
    private EditText name;
    private EditText pass;
    private Button log;
    private LoginPresenter presenterLogin;
    private CheckBox rem_pass;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_me, container, false);
        activity = getActivity();
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        presenterLogin = new LoginPresenter(this);
    }

    private void initView(View inflate) {
        name = inflate.findViewById(R.id.name);
        pass = inflate. findViewById(R.id.pass);
        log = inflate.findViewById(R.id.log);
        rem_pass=inflate.findViewById(R.id.rem_pass);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!name.getText().toString().isEmpty()&&!pass.getText().toString().isEmpty()){
                    presenterLogin.getPresenter(name.getText().toString(),pass.getText().toString(),rem_pass.isChecked());
                }else {
                    Toast.makeText(activity, "账号和密码不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });

        rem_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rem_pass.isChecked()){
                    rem_pass.setChecked(true);
                }else {
                    rem_pass.setChecked(false);
                }
            }
        });
    }

    @Override
    public void onSuccess() {
        startActivity(new Intent(activity, MainActivity.class));
    }

    @Override
    public void onFail(String error) {
        Log.e("TAG1",error);
    }
}