package com.r948.models;

import androidx.lifecycle.MutableLiveData;

/**
 * 商家展示类
 */
public class ShowShop {
    /**
     * 商家名称
     */
    private final MutableLiveData<String> name = new MutableLiveData<>();

    /**
     * 商家头像
     */
    private final MutableLiveData<String> icon = new MutableLiveData<>();

    /**
     * 商家评分
     */
    private final MutableLiveData<Float> score = new MutableLiveData<>();

    /**
     * 商家销量
     */
    private final MutableLiveData<Integer> salesVolume = new MutableLiveData<>();

    /**
     * 用户与商家的距离
     */
    private final MutableLiveData<String> distance = new MutableLiveData<>();


    public MutableLiveData<String> getName() {
        return name;
    }

    public MutableLiveData<String> getIcon() {
        return icon;
    }

    public MutableLiveData<Float> getScore() {
        return score;
    }

    public MutableLiveData<Integer> getSalesVolume() {
        return salesVolume;
    }

    public MutableLiveData<String> getDistance() {
        return distance;
    }

    public ShowShop(String name, String icon, Float score, Integer salesVolume, String distance) {
        this.name.postValue(name);
        this.icon.postValue(icon);
        this.score.postValue(score);
        this.salesVolume.postValue(salesVolume);
        this.distance.postValue(distance);
    }

    public ShowShop() { }
}
