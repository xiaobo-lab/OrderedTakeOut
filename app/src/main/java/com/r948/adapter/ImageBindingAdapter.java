package com.r948.adapter;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class ImageBindingAdapter {
    @BindingAdapter(value = "imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView).load(url).into(imageView);
    }
}
