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

public class RecAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ShouBean.DataDTO.TopicListDTO> list;

    public RecAdapter(Context context, ArrayList<ShouBean.DataDTO.TopicListDTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.topic_item, parent, false);

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
        ShouBean.DataDTO.TopicListDTO topicListDTO = list.get(position);
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.price.setText("￥"+topicListDTO.getPrice_info()+"起");
        viewHolder.descs.setText(topicListDTO.getSubtitle());
        viewHolder.name.setText(topicListDTO.getTitle());
        Glide.with(context).load(topicListDTO.getScene_pic_url()).into(viewHolder.imageView);

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
        private ImageView imageView;
        private TextView   name;
        private TextView   descs;
        private TextView price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.topic_image);
            name=itemView.findViewById(R.id.topic_ai);
            descs=itemView.findViewById(R.id.topic_topic);
            price=itemView.findViewById(R.id.topic_price);

        }
    }
}
