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
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.p7project.R;
import com.example.p7project.bean.ShouBean;

import java.util.ArrayList;

public class GridLayoutHomeAdafel extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<ShouBean.DataDTO.CategoryListDTO.GoodsListDTO> list;
    private GridLayoutHelper gridLayoutHelper;

    public GridLayoutHomeAdafel(Context context, ArrayList<ShouBean.DataDTO.CategoryListDTO.GoodsListDTO> list, GridLayoutHelper gridLayoutHelper) {
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.week_item, parent, false);
        
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShouBean.DataDTO.CategoryListDTO.GoodsListDTO goodsListDTO = list.get(position);
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.name.setText(goodsListDTO.getName());
        viewHolder.price.setText("￥"+goodsListDTO.getRetail_price());
        Glide.with(context).load(goodsListDTO.getList_pic_url()).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView image;
        private TextView name;
        private TextView price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.week_image);
            name=itemView.findViewById(R.id.week_shop);
            price=itemView.findViewById(R.id.week_price);
        }
    }
}
