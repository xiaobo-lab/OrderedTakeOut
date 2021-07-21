package com.r948.models;

import androidx.lifecycle.MutableLiveData;

/**
 * 购物车条目实体类
 */
public class Cart {
    /**
     * 商品名称
     */
    private final MutableLiveData<String> commodityName = new MutableLiveData<>();

    /**
     * 商品价格
     */
    private final MutableLiveData<Float> commodityPrice = new MutableLiveData<>();

    /**
     * 商品数量
     */
    private final MutableLiveData<Integer> commodityNumber = new MutableLiveData<>();

    /**
     * 商品图片
     */
    private final MutableLiveData<String> commodityImage = new MutableLiveData<>();

    /**
     * 所有商品总价
     */
    private final MutableLiveData<Float> totalPrice = new MutableLiveData<>();

    public MutableLiveData<String> getCommodityName() {
        return commodityName;
    }

    public MutableLiveData<Float> getCommodityPrice() {
        return commodityPrice;
    }

    public MutableLiveData<Integer> getCommodityNumber() {
        return commodityNumber;
    }

    public MutableLiveData<Float> getTotalPrice() {
        return totalPrice;
    }

    public MutableLiveData<String> getCommodityImage() {
        return commodityImage;
    }
}
