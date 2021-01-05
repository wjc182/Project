package com.example.p7project.shopcar.adafel;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.p7project.R;
import com.example.p7project.shopcar.bean.ShopBean;

import java.util.ArrayList;

public class ShopCarAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ShopBean.DataDTO.CartListDTO> list;

    public ShopCarAdapter(Context context, ArrayList<ShopBean.DataDTO.CartListDTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shop_car_item, parent, false);

        return new ShopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShopBean.DataDTO.CartListDTO car = list.get(position);
        ShopViewHolder v= (ShopViewHolder) holder;
        v.shop_car_price.setText(car.getRetailPrice());
        v.shop_car_number.setText(car.getNumber());
        v.shop_car_title.setText(car.getGoodsName());
        Glide.with(context).load(car.getListPicUrl()).into(v.shop_car_image);
        boolean checked = v.shop_chose.isChecked();
        //判断点击事件
        if(checked){
            car.setShopCheck(true);
            v.shop_chose.setChecked(true);
        }else {
            car.setShopCheck(false);
            //便于再次取消点击
            v.shop_chose.setChecked(false);
        }


        v.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //接口回调传递

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ShopViewHolder extends RecyclerView.ViewHolder{
        private CheckBox shop_chose;
        private ImageView shop_car_image;
        private TextView shop_car_title;
        private TextView shop_car_price;
        private TextView shop_car_number;
        public ShopViewHolder(@NonNull View itemView) {
            super(itemView);
            shop_chose=itemView.findViewById(R.id.shop_chose);
            shop_car_image=itemView.findViewById(R.id.shop_car_image);
            shop_car_title=itemView.findViewById(R.id.shop_car_title);
            shop_car_price=itemView.findViewById(R.id.shop_car_price);
            shop_car_number=itemView.findViewById(R.id.shop_car_number);
        }
    }
}
