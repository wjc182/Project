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
import com.example.p7project.bean.ZhuanTiBean;

import java.util.ArrayList;

public class ZhuanTiAdafel extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ZhuanTiBean.DataDTO.DataDTOs> list;

    public ZhuanTiAdafel(Context context, ArrayList<ZhuanTiBean.DataDTO.DataDTOs> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fen_rec_item, parent, false);

        return new MyViewHolder(view);
    }

    private ItemListener itemListener;

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }

    public interface ItemListener{
        void itemClick(int pos);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ZhuanTiBean.DataDTO.DataDTOs dataDTOs = list.get(position);
        MyViewHolder viewHolder= (MyViewHolder) holder;
        viewHolder.price.setText(dataDTOs.getPrice_info()+"元");
        viewHolder.subTitle.setText(dataDTOs.getSubtitle());
        viewHolder.title.setText(dataDTOs.getTitle());
        Glide.with(context).load(dataDTOs.getScene_pic_url()).into(viewHolder.imageView);
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


    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView title;
        private TextView   subTitle;
        private TextView price;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.fen_image);
            title=itemView.findViewById(R.id.fen_title);
            subTitle=itemView.findViewById(R.id.fen_subtitle);
            price=itemView.findViewById(R.id.fen_pic);
        }
    }
}
