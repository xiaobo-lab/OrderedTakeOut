package com.r948.viewmodels.takeout.sort.shop.order;

import androidx.lifecycle.MutableLiveData;

import com.r948.data.Repository;
import com.r948.viewmodels.RepoViewModel;

/**
 * 商品
 */
public class CommodityModel extends RepoViewModel {
    /**
     * 商品图片
     */
    private final MutableLiveData<String> imageUrl = new MutableLiveData<>();

    /**
     * 商品名称
     */
    private final MutableLiveData<String> name = new MutableLiveData<>();

    /**
     * 商品评分
     */
    private final MutableLiveData<Float> score = new MutableLiveData<>();

    /**
     * 商品销量
     */
    private final MutableLiveData<Integer> salesVolume = new MutableLiveData<>();

    /**
     * 当前选择数量
     */
    private final MutableLiveData<Integer> number = new MutableLiveData<>();


    public CommodityModel(Repository repo) {
        super(repo);
    }

    public MutableLiveData<String> getImageUrl() {
        return imageUrl;
    }

    public MutableLiveData<String> getName() {
        return name;
    }

    public MutableLiveData<Float> getScore() {
        return score;
    }

    public MutableLiveData<Integer> getSalesVolume() {
        return salesVolume;
    }

    public MutableLiveData<Integer> getNumber() {
        return number;
    }
}
