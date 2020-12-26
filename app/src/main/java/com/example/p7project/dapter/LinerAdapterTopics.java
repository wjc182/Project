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
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.p7project.R;
import com.example.p7project.bean.ShouBean;

import java.util.ArrayList;


public class LinerAdapterTopics extends DelegateAdapter.Adapter {
    private Context context;
    private LinearLayoutHelper linearLayoutHelper;
    private ArrayList<ShouBean.DataDTO.TopicListDTO> list;

    public LinerAdapterTopics(Context context, LinearLayoutHelper linearLayoutHelper, ArrayList<ShouBean.DataDTO.TopicListDTO> list) {
        this.context = context;
        this.linearLayoutHelper = linearLayoutHelper;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.topic_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        ShouBean.DataDTO.TopicListDTO topicListDTO = list.get(position);
        viewHolder.topic.setText(topicListDTO.getSubtitle());
        viewHolder.pice.setText(topicListDTO.getPrice_info());
        viewHolder.title.setText(topicListDTO.getTitle());
        Glide.with(context).load(topicListDTO.getScene_pic_url()).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView pice;
        private ImageView image;
        private TextView topic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.topic_ai);
            pice=itemView.findViewById(R.id.topic_price);
            image=itemView.findViewById(R.id.topic_image);
            topic=itemView.findViewById(R.id.topic_topic);
        }
    }
}
