package com.example.p7project.fenadafel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.p7project.R;
import com.example.p7project.bean.FenLeiRightBean;

import java.util.ArrayList;

public class FenRightRecAdafel extends  DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<FenLeiRightBean.DataDTO> list;
    private GridLayoutHelper gridLayoutHelper;


    public FenRightRecAdafel(Context context, ArrayList<FenLeiRightBean.DataDTO> list, GridLayoutHelper gridLayoutHelper ) {
        this.context = context;
        this.list = list;
        this.gridLayoutHelper = gridLayoutHelper;

    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.right_title_image, parent, false);
        return new RightViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FenLeiRightBean.DataDTO dataDTO = list.get(position);
        RightViewHolder v= (RightViewHolder) holder;
        Glide.with(context).load(dataDTO.getCurrentCategory().getWap_banner_url()).into(v.titleImage);
        v.right_title_title.setText(dataDTO.getCurrentCategory().getFront_desc());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class RightViewHolder extends RecyclerView.ViewHolder{

        private ImageView titleImage;
        private TextView right_title_title;

        public RightViewHolder(@NonNull View itemView) {
            super(itemView);
            titleImage = itemView.findViewById(R.id.right_title_image);
            right_title_title=itemView.findViewById(R.id.right_title_title);

        }
    }
}
