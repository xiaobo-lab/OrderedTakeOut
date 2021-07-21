package com.r948.models;

import androidx.lifecycle.MutableLiveData;

/**
 * 购物车条目实体类
 */
public class Cart {
    /**
     * 商家名称
     */
    private final MutableLiveData<String> shopName = new MutableLiveData<>();

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

    public MutableLiveData<String> getShopName() {
        return shopName;
    }

    public MutableLiveData<String> getCommodityName() {
        return commodityName;
    }

    public MutableLiveData<Float> getCommodityPrice() {
        return commodityPrice;
    }

    public MutableLiveData<Integer> getCommodityNumber() {
        return commodityNumber;
    }
}
