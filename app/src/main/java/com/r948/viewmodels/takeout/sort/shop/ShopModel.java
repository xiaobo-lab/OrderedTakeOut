package com.r948.viewmodels.takeout.sort.shop;

import androidx.lifecycle.MutableLiveData;

import com.r948.data.Repository;
import com.r948.viewmodels.RepoViewModel;

/**
 * 店铺页面
 */
public class ShopModel extends RepoViewModel {
    /**
     * 商家图片
     */
    private final MutableLiveData<String> shopIcon = new MutableLiveData<>();

    /**
     * 商家评分
     */
    private final MutableLiveData<String> shopScore = new MutableLiveData<>();

    /**
     * 商家销量
     */
    private final MutableLiveData<String> shopSalesVolume = new MutableLiveData<>();

    public ShopModel(Repository repo) {
        super(repo);
    }

    public MutableLiveData<String> getShopIcon() {
        return shopIcon;
    }

    public MutableLiveData<String> getShopScore() {
        return shopScore;
    }

    public MutableLiveData<String> getShopSalesVolume() {
        return shopSalesVolume;
    }
}
