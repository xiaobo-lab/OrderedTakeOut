package com.r948.viewmodels.takeout;

import androidx.lifecycle.MutableLiveData;

import com.r948.data.Repository;
import com.r948.models.ShowShop;
import com.r948.viewmodels.RepoViewModel;

import java.util.List;

/**
 * 外卖界面需要的信息
 */
public class TakeoutModel extends RepoViewModel {
    /**
     * 外卖页面的走马灯图片 url
     */
    private final MutableLiveData<List<String>> horseLamp = new MutableLiveData<>();

    /**
     * 附近所有的可推荐商家
     */
    private final MutableLiveData<List<ShowShop>> showShops = new MutableLiveData<>();

    public TakeoutModel(Repository repo) {
        super(repo);
    }

    public MutableLiveData<List<String>> getHorseLamp() {
        return horseLamp;
    }

    public MutableLiveData<List<ShowShop>> getShowShops() {
        return showShops;
    }
}
