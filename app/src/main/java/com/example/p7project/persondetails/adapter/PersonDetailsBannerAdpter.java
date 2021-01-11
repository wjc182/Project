package com.example.p7project.weekdetails.adafel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.p7project.R;
import com.example.p7project.dapter.SingleLayoutAdapter;
import com.example.p7project.weekdetails.bean.BuyBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class WeekDetailsBannerAdpter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<BuyBean.DataDTO.GalleryDTO> list;
    private SingleLayoutHelper singleLayoutHelper;

    public WeekDetailsBannerAdpter(Context context, ArrayList<BuyBean.DataDTO.GalleryDTO> list, SingleLayoutHelper singleLayoutHelper) {
        this.context = context;
        this.list = list;
        this.singleLayoutHelper = singleLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.week_banner_details, parent, false);

        return new WeekBannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        WeekBannerViewHolder viewHolder= (WeekBannerViewHolder) holder;
        viewHolder.banner.setImages(list)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        BuyBean.DataDTO.GalleryDTO newPath= (BuyBean.DataDTO.GalleryDTO) path;

                        Glide.with(context).load(newPath.getImg_url()).into(imageView);
                    }
                }).start();

    }

    @Override
    public int getItemCount() {
        return 1;
    }
    class WeekBannerViewHolder extends RecyclerView.ViewHolder{
        private Banner banner;

        public WeekBannerViewHolder(@NonNull View itemView) {
            super(itemView);
            banner=itemView.findViewById(R.id.week_banner_image);
        }
    }
}
