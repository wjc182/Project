package com.example.p7project.dapter;

import android.content.Context;
import android.util.Log;
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

public class GridLayoutHelperPeson extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<ShouBean.DataDTO.HotGoodsListDTO> list;
    private GridLayoutHelper gridLayoutHelper2;

    public GridLayoutHelperPeson(Context context, ArrayList<ShouBean.DataDTO.HotGoodsListDTO> list, GridLayoutHelper gridLayoutHelper2) {
        this.context = context;
        this.list = list;
        this.gridLayoutHelper2 = gridLayoutHelper2;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper2;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.person_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
         ViewHolder viewHolder= (ViewHolder) holder;
        ShouBean.DataDTO.HotGoodsListDTO hotGoodsListDTO = list.get(position);
        viewHolder.name_title.setText(hotGoodsListDTO.getGoods_brief());
        viewHolder.name.setText(hotGoodsListDTO.getName());
        viewHolder.price.setText("￥"+hotGoodsListDTO.getRetail_price());
        Glide.with(context).load(hotGoodsListDTO.getList_pic_url()).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView image;
        private TextView name;
        private TextView price;
        private TextView name_title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.per_image);
            name=itemView.findViewById(R.id.per_shop);
            price=itemView.findViewById(R.id.per_price);
            name_title=itemView.findViewById(R.id.per_shopTitle);
        }
    }
}
