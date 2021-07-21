package com.r948.orderedtakeout.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.r948.orderedtakeout.data.Repository;

public class TakeoutModel extends RepoViewModel {
    // 当前所在地区 (通过定位获得)
    private final MutableLiveData<String> location = new MutableLiveData<>();

    public TakeoutModel(Repository repo) {
        super(repo);
    }
}
