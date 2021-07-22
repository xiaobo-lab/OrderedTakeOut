package com.r948.viewmodels.takeout.sort.shop.info;

import androidx.lifecycle.MutableLiveData;

import com.r948.data.Repository;
import com.r948.viewmodels.RepoViewModel;

/**
 * 店铺-信息
 */
public class ShopInfoModel extends RepoViewModel {
    /**
     * 商家电话
     */
    private final MutableLiveData<String> phone = new MutableLiveData<>();

    /**
     * 商家地址
     */
    private final MutableLiveData<String> address = new MutableLiveData<>();

    /**
     * 营业时间
     */
    private final MutableLiveData<String> businessHour = new MutableLiveData<>();

    public ShopInfoModel(Repository repo, MutableLiveData<String> toastMsg) {
        super(repo, toastMsg);
    }

    public MutableLiveData<String> getPhone() {
        return phone;
    }

    public MutableLiveData<String> getAddress() {
        return address;
    }

    public MutableLiveData<String> getBusinessHour() {
        return businessHour;
    }
}
