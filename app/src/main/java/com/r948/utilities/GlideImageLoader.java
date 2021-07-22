package com.r948.utilities;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

public class GlideImageLoader extends BannerAdapter<String, GlideImageLoader.ViewHolder> {
    public GlideImageLoader(List<String> datas) {
        super(datas);
    }

    @Override
    public ViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new ViewHolder(imageView);
    }

    @Override
    public void onBindView(ViewHolder holder, String data, int position, int size) {
        Glide.with(holder.imageView).load(data).centerCrop().into(holder.imageView);
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;

        public ViewHolder(@NonNull ImageView itemView) {
            super(itemView);
            this.imageView = itemView;
        }
    }
}
