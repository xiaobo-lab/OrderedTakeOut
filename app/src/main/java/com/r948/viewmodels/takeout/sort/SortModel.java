package com.r948.viewmodels.takeout.sort;

import androidx.lifecycle.MutableLiveData;

import com.r948.data.Repository;
import com.r948.models.ShowShop;
import com.r948.viewmodels.RepoViewModel;

import java.util.List;

/**
 * 商品分类查看页，如：早餐页
 */
public class SortModel extends RepoViewModel {

    /**
     * 该分类下所有商店
     */
    private final MutableLiveData<List<ShowShop>> showShops = new MutableLiveData<>();

    /**
     * 搜索结果页中搜索结果部分，用户选择的排序方式，
     * 取值为 {@link com.r948.utilities.Constants.SortKind}
     */
    private final MutableLiveData<String> sortKind = new MutableLiveData<>();

    public SortModel(Repository repo, MutableLiveData<String> toastMsg) {
        super(repo, toastMsg);
    }

    public MutableLiveData<List<ShowShop>> getShowShops() {
        return showShops;
    }

    public MutableLiveData<String> getSortKind() {
        return sortKind;
    }
}
