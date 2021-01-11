package com.example.p7project.zhuanti.adapter;

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
import com.example.p7project.zhuanti.bean.Talkbean;

import java.util.ArrayList;

public class TalkAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private GridLayoutHelper gridLayoutHelper;
    private ArrayList<Talkbean.DataDTO.DataDTOs> list;

    public TalkAdapter(Context context, GridLayoutHelper gridLayoutHelper, ArrayList<Talkbean.DataDTO.DataDTOs> list) {
        this.context = context;
        this.gridLayoutHelper = gridLayoutHelper;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return 0;
        }else {
            return 1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       if(viewType==0){
           View view = LayoutInflater.from(context).inflate(R.layout.talk_timer_name, parent, false);
           return new TalkViewHolder(view);
       }else {
           View view = LayoutInflater.from(context).inflate(R.layout.talk_title, parent, false);
           return new TalkViewHolder(view);
       }
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        TalkViewHolder talkViewHolder= (TalkViewHolder) holder;
        if(itemViewType==0){
            Talkbean.DataDTO.DataDTOs dataDTOs = list.get(position);
            talkViewHolder.timer.setText(dataDTOs.getAddTime());
            talkViewHolder.name.setText(dataDTOs.getUserInfo().getUsername());
            Glide.with(context).load(dataDTOs.getUserInfo().getAvatar()).into(talkViewHolder.image);
       }else {
           Talkbean.DataDTO.DataDTOs dataDTOs = list.get(position);
           talkViewHolder.title.setText(dataDTOs.getContent());
       }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class TalkViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private ImageView image;
        private TextView timer;
        private TextView name;

        public TalkViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.talk_content);
            image=itemView.findViewById(R.id.talk_touxiang);
            timer=itemView.findViewById(R.id.talk_timer);
            name=itemView.findViewById(R.id.talk_name);
        }
    }
}
