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

public class GridLayoutHelperAdafel extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<ShouBean.DataDTO.BrandListDTO> list;
    private GridLayoutHelper gridLayoutHelper;

    public GridLayoutHelperAdafel(Context context, ArrayList<ShouBean.DataDTO.BrandListDTO> list, GridLayoutHelper gridLayoutHelper) {
        this.context = context;
        this.list = list;
        this.gridLayoutHelper = gridLayoutHelper;
    }




    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    private ItemListener itemListener;

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }

    public ItemListener getItemListener() {
        return itemListener;
    }

    public interface ItemListener{
        void itemClick(int  pos);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           View inflate = LayoutInflater.from(context).inflate(R.layout.grild_item1, parent, false);

           return new ViewHolder(inflate);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            ShouBean.DataDTO.BrandListDTO brandListDTO = list.get(position);
            ViewHolder viewHolder= (ViewHolder) holder;
            viewHolder.price.setText(brandListDTO.getFloor_price()+"元起");
            viewHolder.name.setText(brandListDTO.getName());
            Glide.with(context).load(brandListDTO.getNew_pic_url() ).into(viewHolder.image);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemListener.itemClick(position);
            }
        });

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
            image=itemView.findViewById(R.id.brand_image);
            name=itemView.findViewById(R.id.brand_shop);
            price=itemView.findViewById(R.id.brand_price);
        }
    }

}
