package com.r948.viewmodels.order.info;

import androidx.lifecycle.MutableLiveData;

import com.r948.data.Repository;
import com.r948.viewmodels.RepoViewModel;

/**
 * 配送进度
 */
public class DeliverModel extends RepoViewModel {
    /**
     * 骑手图标
     */
    private final MutableLiveData<String> deliverIcon = new MutableLiveData<>();

    /**
     * 目的地用户图标
     */
    private final MutableLiveData<String> userIcon = new MutableLiveData<>();

    /**
     * 商家图标
     */
    private final MutableLiveData<String> shopIcon = new MutableLiveData<>();

    /**
     * 预计送达时间
     */
    private final MutableLiveData<String> estimateDeliveredTime = new MutableLiveData<>();

    /**
     * 骑手经度
     */
    private final MutableLiveData<Double> deliverLon = new MutableLiveData<>();

    /**
     * 骑手纬度
     */
    private final MutableLiveData<Double> deliverLat = new MutableLiveData<>();

    /**
     * 用户经度
     */
    private final MutableLiveData<Double> userLon = new MutableLiveData<>();

    /**
     * 用户纬度
     */
    private final MutableLiveData<Double> userLat = new MutableLiveData<>();

    /**
     * 商家经度
     */
    private final MutableLiveData<Double> shopLon = new MutableLiveData<>();

    /**
     * 商家纬度
     */
    private final MutableLiveData<Double> shopLat = new MutableLiveData<>();

    /**
     * 骑手手机号
     */
    private final MutableLiveData<String> deliverPhone = new MutableLiveData<>();

    /**
     * 商家手机号
     */
    private final MutableLiveData<String> shopPhone = new MutableLiveData<>();

    public DeliverModel(Repository repo, MutableLiveData<String> toastMsg) {
        super(repo, toastMsg);
    }

    public MutableLiveData<String> getDeliverIcon() {
        return deliverIcon;
    }

    public MutableLiveData<String> getUserIcon() {
        return userIcon;
    }

    public MutableLiveData<String> getShopIcon() {
        return shopIcon;
    }

    public MutableLiveData<String> getEstimateDeliveredTime() {
        return estimateDeliveredTime;
    }

    public MutableLiveData<Double> getDeliverLon() {
        return deliverLon;
    }

    public MutableLiveData<Double> getDeliverLat() {
        return deliverLat;
    }

    public MutableLiveData<Double> getUserLon() {
        return userLon;
    }

    public MutableLiveData<Double> getUserLat() {
        return userLat;
    }

    public MutableLiveData<Double> getShopLon() {
        return shopLon;
    }

    public MutableLiveData<Double> getShopLat() {
        return shopLat;
    }

    public MutableLiveData<String> getDeliverPhone() {
        return deliverPhone;
    }

    public MutableLiveData<String> getShopPhone() {
        return shopPhone;
    }
}
