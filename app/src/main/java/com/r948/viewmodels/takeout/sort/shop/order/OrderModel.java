package com.r948.viewmodels.takeout.sort.shop.order;

import androidx.lifecycle.MutableLiveData;

import com.r948.data.Repository;
import com.r948.models.Cart;
import com.r948.viewmodels.RepoViewModel;

import java.util.List;

/**
 * 订单页面
 */
public class OrderModel extends RepoViewModel {
    /**
     * 商家名称
     */
    private final MutableLiveData<String> shopName = new MutableLiveData<>();

    /**
     * 购物信息
     */
    private final MutableLiveData<List<Cart>> shoppingCart = new MutableLiveData<>();

    /**
     * 收货地址
     */
    private final MutableLiveData<String> address = new MutableLiveData<>();

    /**
     * 收货名称
     */
    private final MutableLiveData<String> addressName = new MutableLiveData<>();

    /**
     * 收货人名称
     */
    private final MutableLiveData<String> userName = new MutableLiveData<>();

    /**
     * 收货人手机号
     */
    private final MutableLiveData<String> userPhone = new MutableLiveData<>();

    /**
     * 预计送达时间
     */
    private final MutableLiveData<String> estimateDeliveredTime = new MutableLiveData<>();

    public OrderModel(Repository repo) {
        super(repo);
    }

    public MutableLiveData<List<Cart>> getShoppingCart() {
        return shoppingCart;
    }

    public MutableLiveData<String> getAddress() {
        return address;
    }

    public MutableLiveData<String> getAddressName() {
        return addressName;
    }

    public MutableLiveData<String> getUserName() {
        return userName;
    }

    public MutableLiveData<String> getUserPhone() {
        return userPhone;
    }

    public MutableLiveData<String> getEstimateDeliveredTime() {
        return estimateDeliveredTime;
    }

    public MutableLiveData<String> getShopName() {
        return shopName;
    }
}
