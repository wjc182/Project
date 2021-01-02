package com.example.p7project.fendapter;

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
import com.example.p7project.bean.FenLeiBean;
import com.example.p7project.bean.ShouBean;

import java.util.ArrayList;

public class GridLayoutFenAdafel extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<FenLeiBean.DataDTO.CurrentCategoryDTO.SubCategoryListDTO> list;
    private GridLayoutHelper gridLayoutHelper;

    public GridLayoutFenAdafel(Context context, ArrayList<FenLeiBean.DataDTO.CurrentCategoryDTO.SubCategoryListDTO> list, GridLayoutHelper gridLayoutHelper) {
        this.context = context;
        this.list = list;
        this.gridLayoutHelper = gridLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.grild_fen_item, parent, false);
        
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
        FenLeiBean.DataDTO.CurrentCategoryDTO.SubCategoryListDTO subCategoryListDTO = list.get(position);
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.name.setText(subCategoryListDTO.getName());
        Glide.with(context).load(subCategoryListDTO.getWap_banner_url()).into(viewHolder.image);
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
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.fen_image);
            name=itemView.findViewById(R.id.fen_name);
        }
    }
}
