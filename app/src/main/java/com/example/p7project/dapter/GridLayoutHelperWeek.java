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

public class GridLayoutHelperWeek extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<ShouBean.DataDTO.NewGoodsListDTO> list;
    private GridLayoutHelper gridLayoutHelper2;

    public GridLayoutHelperWeek(Context context, ArrayList<ShouBean.DataDTO.NewGoodsListDTO> list, GridLayoutHelper gridLayoutHelper2) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.week_item, parent, false);
        return new ViewHolder(view);
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

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
         ViewHolder viewHolder= (ViewHolder) holder;
        ShouBean.DataDTO.NewGoodsListDTO listDTO = list.get(position);
        Log.e("Food",listDTO.toString());
        viewHolder.name.setText(listDTO.getName());
        viewHolder.price.setText("￥"+listDTO.getRetail_price());
        Glide.with(context).load(listDTO.getList_pic_url()).into(viewHolder.image);

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
            image=itemView.findViewById(R.id.week_image);
            name=itemView.findViewById(R.id.week_shop);
            price=itemView.findViewById(R.id.week_price);
        }
    }
}
