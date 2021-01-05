package com.example.p7project.fenadafel;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.p7project.R;
import com.example.p7project.bean.FenLeiBean;

import java.util.ArrayList;

public class FenLeftRecAdafel extends RecyclerView.Adapter {
 private Context context;
 private ArrayList<FenLeiBean.DataDTO.CategoryListDTO> list;
    private int adapterPosition;

    public FenLeftRecAdafel(Context context, ArrayList<FenLeiBean.DataDTO.CategoryListDTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fen_left_rec, parent, false);

        return new LeftViewHolder(view);
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
        FenLeiBean.DataDTO.CategoryListDTO categoryListDTO = list.get(position);
        LeftViewHolder v= (LeftViewHolder) holder;

        if(adapterPosition!=position){
            v.choose.setVisibility(View.GONE);
        }else {
            v.choose.setVisibility(View.VISIBLE);
        }

        v.leftName.setText(categoryListDTO.getName());
        v.itemView.setOnClickListener(view->{
            adapterPosition = v.getAdapterPosition();
            itemListener.itemClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class LeftViewHolder extends RecyclerView.ViewHolder{
        private TextView leftName;
        private View choose;
        public LeftViewHolder(@NonNull View itemView) {
            super(itemView);
            leftName=itemView.findViewById(R.id.left_text);
            choose=itemView.findViewById(R.id.left_choose);
        }
    }
}
