package com.r948.viewmodels.order;

import androidx.lifecycle.MutableLiveData;

import com.r948.data.Repository;
import com.r948.viewmodels.RepoViewModel;

/**
 * 订单
 */
public class OrderModel extends RepoViewModel {
    /**
     * 商家图片
     */
    private final MutableLiveData<String> shopImage = new MutableLiveData<>();

    /**
     * 商家名称
     */
    private final MutableLiveData<String> shopName = new MutableLiveData<>();

    /**
     * 订单中第一个商品名称以及订单总数量
     */
    private final MutableLiveData<String> commodityIntroduction = new MutableLiveData<>();

    /**
     * 订单总价
     */
    private final MutableLiveData<Float> totalPrice = new MutableLiveData<>();

    /**
     * 订单状态
     */
    private final MutableLiveData<String> state = new MutableLiveData<>();

    public OrderModel(Repository repo) {
        super(repo);
    }

    public MutableLiveData<String> getShopImage() {
        return shopImage;
    }

    public MutableLiveData<String> getShopName() {
        return shopName;
    }

    public MutableLiveData<String> getCommodityIntroduction() {
        return commodityIntroduction;
    }

    public MutableLiveData<Float> getTotalPrice() {
        return totalPrice;
    }

    public MutableLiveData<String> getState() {
        return state;
    }

}
