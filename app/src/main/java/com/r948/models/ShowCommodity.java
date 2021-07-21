package com.r948.models;

import androidx.lifecycle.MutableLiveData;

public class ShowCommodity {
    /**
     * 商品图片
     */
    private final MutableLiveData<String> image = new MutableLiveData<>();

    /**
     * 商品名称
     */
    private final MutableLiveData<String> name = new MutableLiveData<>();

    /**
     * 商品销量
     */
    private final MutableLiveData<Integer> salesVolume = new MutableLiveData<>();

    /**
     * 商品单价
     */
    private final MutableLiveData<Float> price = new MutableLiveData<>();

    /**
     * 商品评分
     */
    private final MutableLiveData<Float> score = new MutableLiveData<>();

    public MutableLiveData<String> getImage() {
        return image;
    }

    public MutableLiveData<String> getName() {
        return name;
    }

    public MutableLiveData<Integer> getSalesVolume() {
        return salesVolume;
    }

    public MutableLiveData<Float> getPrice() {
        return price;
    }

    public MutableLiveData<Float> getScore() {
        return score;
    }
}
