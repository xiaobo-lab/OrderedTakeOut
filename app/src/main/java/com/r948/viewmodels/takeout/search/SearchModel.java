package com.r948.viewmodels.takeout.search;

import androidx.lifecycle.MutableLiveData;

import com.r948.models.ShowShop;

import java.util.List;

/**
 * 搜索界面需要的信息
 */
public class SearchModel {
    /**
     * 搜索到的所有商家
     */
    private final MutableLiveData<List<ShowShop>> showShops = new MutableLiveData<>();



}
