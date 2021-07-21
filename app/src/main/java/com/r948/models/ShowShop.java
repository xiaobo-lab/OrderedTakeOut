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
     * 商家得分
     */
    private final MutableLiveData<Float> score = new MutableLiveData<>();

    /**
     * 商家销量
     */
    private final MutableLiveData<Integer> salesVolume = new MutableLiveData<>();

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
}
