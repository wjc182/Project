package com.example.p7project.fenadafel;

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
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.p7project.R;
import com.example.p7project.bean.FenLeiRightBean;

import java.util.ArrayList;

public class RewRightAdafel extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<FenLeiRightBean.DataDTO.CurrentCategoryDTO.SubCategoryListDTO> list;
    private GridLayoutHelper gridLayoutHelper;

    public RewRightAdafel(Context context, ArrayList<FenLeiRightBean.DataDTO.CurrentCategoryDTO.SubCategoryListDTO> list, GridLayoutHelper gridLayoutHelper) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.fen_right_rec, parent, false);
        return new RightViewHolders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FenLeiRightBean.DataDTO.CurrentCategoryDTO.SubCategoryListDTO sub = list.get(position);
        RightViewHolders v= (RightViewHolders) holder;
        Glide.with(context).load(sub.getWap_banner_url()).into(v.titleImage);
        v.fen_text_right.setText(sub.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class RightViewHolders extends RecyclerView.ViewHolder{

        private ImageView titleImage;
        private TextView fen_text_right;

        public RightViewHolders(@NonNull View itemView) {
            super(itemView);
            titleImage = itemView.findViewById(R.id.fen_image_right);
            fen_text_right=itemView.findViewById(R.id.fen_text_right);
        }
    }
}
