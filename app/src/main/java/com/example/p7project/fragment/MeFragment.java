package com.example.p7project.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.p7project.MainActivity;
import com.example.p7project.R;


public class MeFragment extends Fragment {


    private FragmentActivity activity;
    private EditText name;
    private EditText pass;
    private Button log;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_me, container, false);
        activity = getActivity();
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        name = inflate.findViewById(R.id.name);
        pass = inflate. findViewById(R.id.pass);
        log = inflate.findViewById(R.id.log);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!name.getText().toString().isEmpty()&&!pass.getText().toString().isEmpty()){
                    startActivity(new Intent(activity, MainActivity.class));
                }else {
                    Toast.makeText(activity, "账号和密码不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}