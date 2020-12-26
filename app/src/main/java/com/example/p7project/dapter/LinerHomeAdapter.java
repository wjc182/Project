package com.example.p7project.dapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.p7project.R;
import com.example.p7project.bean.ShouBean;

import java.util.ArrayList;


public class LinerHomeAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private LinearLayoutHelper linearLayoutHelper;
    private ArrayList<ShouBean.DataDTO.CategoryListDTO> list;

    public LinerHomeAdapter(Context context, LinearLayoutHelper linearLayoutHelper, ArrayList<ShouBean.DataDTO.CategoryListDTO> list) {
        this.context = context;
        this.linearLayoutHelper = linearLayoutHelper;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_title, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        ShouBean.DataDTO.CategoryListDTO categoryListDTO = list.get(position);
        viewHolder.title.setText(categoryListDTO.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.home_titles);
        }
    }
}
