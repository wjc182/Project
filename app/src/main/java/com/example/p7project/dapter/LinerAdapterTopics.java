package com.example.p7project.dapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.p7project.R;
import com.example.p7project.bean.ShouBean;

import java.util.ArrayList;


public class LinerAdapterTopics extends DelegateAdapter.Adapter{
    private Context context;
    private ArrayList<ShouBean.DataDTO.TopicListDTO> list;
    private   LinearLayoutHelper linearLayoutHelper;
    private int xOffset;
    private int position;
    private RecyclerView.RecycledViewPool viewPool;

    public LinerAdapterTopics(Context context, ArrayList<ShouBean.DataDTO.TopicListDTO> list, LinearLayoutHelper linearLayoutHelper,RecyclerView.RecycledViewPool viewPool) {
        this.context = context;
        this.list = list;
        this.linearLayoutHelper = linearLayoutHelper;
        this.viewPool=viewPool;
    }

    @Override
    public int getItemViewType(int position) {
        return 3;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.topic_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder.itemView instanceof  RecyclerView){
            RecyclerView recyclerView= (RecyclerView) holder.itemView;
            recyclerView.setRecycledViewPool(viewPool);
        }
        ViewHolder viewHolder= (ViewHolder) holder;
        ShouBean.DataDTO.TopicListDTO topicListDTO = list.get(position);
        viewHolder.topic.setText(topicListDTO.getSubtitle());
        viewHolder.pice.setText(topicListDTO.getPrice_info()+"元起");
        viewHolder.title.setText(topicListDTO.getTitle());
        Glide.with(context).load(topicListDTO.getScene_pic_url()).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
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

    @Override
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder holder) {
        if (holder.itemView instanceof RecyclerView) {
            RecyclerView recyclerView = ((RecyclerView) holder.itemView);
            LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
            position = manager.findFirstVisibleItemPosition();
            View view = manager.findViewByPosition(position);
            ViewGroup.MarginLayoutParams lp =
                    (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (view != null) {
                //如果你设置了margin则减去
                xOffset = view.getLeft() - lp.leftMargin;
            }
        }

        super.onViewDetachedFromWindow(holder);
    }

    @Override
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder holder) {
        if (holder.itemView instanceof RecyclerView) {
            RecyclerView recyclerView = ((RecyclerView) holder.itemView);
            LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
            manager.scrollToPositionWithOffset(position, xOffset);
        }
        super.onViewAttachedToWindow(holder);
    }
}
