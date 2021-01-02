package com.example.p7project.fendapter;

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
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.p7project.R;
import com.example.p7project.bean.FenLeiBean;
import com.example.p7project.bean.ShouBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class SingleLayoutAdapterFenLei extends DelegateAdapter.Adapter {
    private ArrayList<FenLeiBean.DataDTO.CategoryListDTO> list;
    private Context context;
    private SingleLayoutHelper singleLayoutHelper;

    public SingleLayoutAdapterFenLei(ArrayList<FenLeiBean.DataDTO.CategoryListDTO> list, Context context, SingleLayoutHelper singleLayoutHelper) {
        this.list = list;
        this.context = context;
        this.singleLayoutHelper = singleLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return new SingleLayoutHelper();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fen_item, parent, false);

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
        FenLeiBean.DataDTO.CategoryListDTO categoryListDTO = list.get(position);

        viewHolder.desc.setText(categoryListDTO.getFront_desc());
        Glide.with(context).load(categoryListDTO.getWap_banner_url()).into(viewHolder.wap_banner);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemListener.itemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 1;

    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView wap_banner;
        private TextView desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            wap_banner=itemView.findViewById(R.id.wap_banner_url);
            desc=itemView.findViewById(R.id.front_desc);
        }
    }


}
