package com.r948.viewmodels.takeout;

import androidx.lifecycle.MutableLiveData;

import com.r948.data.Repository;
import com.r948.models.ShowShop;
import com.r948.viewmodels.RepoViewModel;

import java.util.List;

/**
 * 外卖
 */
public class TakeoutModel extends RepoViewModel {
    /**
     * 外卖页面的走马灯图片 url
     */
    private final MutableLiveData<List<String>> horseLamp = new MutableLiveData<>();

    /**
     * 外卖页中推荐商家部分，用户选择的排序方式，
     * 取值为 {@link com.r948.utilities.Constants.SortKind}
     */
    private final MutableLiveData<String> sortKind = new MutableLiveData<>();

    /**
     * 附近所有的可推荐商家
     */
    private final MutableLiveData<List<ShowShop>> showShops = new MutableLiveData<>();

    public TakeoutModel(Repository repo, MutableLiveData<String> toastMsg) {
        super(repo, toastMsg);
    }


    public MutableLiveData<List<String>> getHorseLamp() {
        return horseLamp;
    }

    public MutableLiveData<String> getSortKind() {
        return sortKind;
    }

    public MutableLiveData<List<ShowShop>> getShowShops() {
        return showShops;
    }

    public void updateHorseLamp() {
        horseLamp.postValue(repo.queryNetHorseLamp());
    }
}
