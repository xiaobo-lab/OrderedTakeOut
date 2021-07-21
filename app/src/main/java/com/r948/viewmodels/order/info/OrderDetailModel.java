package com.r948.viewmodels.order.info;

import androidx.lifecycle.MutableLiveData;

import com.r948.data.Repository;
import com.r948.models.Cart;
import com.r948.viewmodels.RepoViewModel;

import java.util.List;

/**
 * 订单详情
 */
public class OrderDetailModel extends RepoViewModel {
    /**
     * 商家名称
     */
    private final MutableLiveData<String> shopName = new MutableLiveData<>();

    /**
     * 订单状态
     */
    private final MutableLiveData<String> state = new MutableLiveData<>();

    /**
     * 预计送达时间
     */
    private final MutableLiveData<String> estimateDeliveredTime = new MutableLiveData<>();

    /**
     * 订单列表
     */
    private final MutableLiveData<List<Cart>> orderList = new MutableLiveData<>();

    /**
     * 实际送达时间
     */
    private final MutableLiveData<String> actualDeliveredTime = new MutableLiveData<>();

    /**
     * 收货地址
     */
    private final MutableLiveData<String> address = new MutableLiveData<>();

    /**
     * 订单号
     */
    private final MutableLiveData<String> orderId = new MutableLiveData<>();

    /**
     * 下单时间
     */
    private final MutableLiveData<String> orderTime = new MutableLiveData<>();

    public OrderDetailModel(Repository repo) {
        super(repo);
    }

    public MutableLiveData<String> getState() {
        return state;
    }

    public MutableLiveData<String> getEstimateDeliveredTime() {
        return estimateDeliveredTime;
    }

    public MutableLiveData<List<Cart>> getOrderList() {
        return orderList;
    }

    public MutableLiveData<String> getActualDeliveredTime() {
        return actualDeliveredTime;
    }

    public MutableLiveData<String> getAddress() {
        return address;
    }

    public MutableLiveData<String> getOrderId() {
        return orderId;
    }

    public MutableLiveData<String> getOrderTime() {
        return orderTime;
    }

    public MutableLiveData<String> getShopName() {
        return shopName;
    }
}
