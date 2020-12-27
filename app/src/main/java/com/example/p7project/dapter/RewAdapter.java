package com.example.p7project.dapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.p7project.R;
import com.example.p7project.bean.ShouBean;

import java.util.ArrayList;


public class RewAdapter extends RecyclerView.Adapter {
    private ArrayList<ShouBean.DataDTO.CategoryListDTO.GoodsListDTO> list;
    private Context context;

    public RewAdapter(ArrayList<ShouBean.DataDTO.CategoryListDTO.GoodsListDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          View inflate = LayoutInflater.from(context).inflate(R.layout.week_item1, parent, false);
          return new ViewHolder(inflate);
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShouBean.DataDTO.CategoryListDTO.GoodsListDTO goodsListDTO = list.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.name.setText(goodsListDTO.getName());
        viewHolder.price.setText("￥" + goodsListDTO.getRetail_price());
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
            image=itemView.findViewById(R.id.week_image1);
            name=itemView.findViewById(R.id.week_shop1);
            price=itemView.findViewById(R.id.week_price1);
        }
    }
}
