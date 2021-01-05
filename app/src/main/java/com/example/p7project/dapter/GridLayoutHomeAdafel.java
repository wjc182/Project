package com.example.p7project.dapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.p7project.R;
import com.example.p7project.bean.ShouBean;

import java.util.ArrayList;
import java.util.List;

public class GridLayoutHomeAdafel extends DelegateAdapter.Adapter {
    private Context context;
    private GridLayoutHelper gridLayoutHelper;
    private ArrayList<ShouBean.DataDTO.CategoryListDTO> list;
    private RewAdapter rewAdapter;

    public GridLayoutHomeAdafel(Context context, GridLayoutHelper gridLayoutHelper, ArrayList<ShouBean.DataDTO.CategoryListDTO> list) {
        this.context = context;
        this.gridLayoutHelper = gridLayoutHelper;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.rew_item, parent, false);
        
        return new ViewHolder(inflate);
    }

    private ItemListener itemListener;

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }


    public interface ItemListener{
        void itemClick(int  pos);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShouBean.DataDTO.CategoryListDTO categoryListDTO = list.get(position);
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.name.setText(categoryListDTO.getName());

        viewHolder.recyclerView.setLayoutManager(new GridLayoutManager(context,2));
        ArrayList<ShouBean.DataDTO.CategoryListDTO.GoodsListDTO> goodsList = (ArrayList<ShouBean.DataDTO.CategoryListDTO.GoodsListDTO>) categoryListDTO.getGoodsList();
        rewAdapter=new RewAdapter(goodsList,context);
        viewHolder.recyclerView.setAdapter(rewAdapter);

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
        private RecyclerView recyclerView;
        private TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView=itemView.findViewById(R.id.rec_rec);
            name=itemView.findViewById(R.id.text_name);
        }
    }
}
