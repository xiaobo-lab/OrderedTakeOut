package com.r948.viewmodels.takeout.search;

import androidx.lifecycle.MutableLiveData;

import com.r948.data.Repository;
import com.r948.models.ShowShop;
import com.r948.viewmodels.RepoViewModel;

import java.util.List;

/**
 * 搜索
 */
public class SearchModel extends RepoViewModel {
    /**
     * 用户输入的搜索信息
     */
    private final MutableLiveData<String> search = new MutableLiveData<>();

    /**
     * 搜索到的所有商家
     */
    private final MutableLiveData<List<ShowShop>> showShops = new MutableLiveData<>();

    /**
     * 搜索结果页中搜索结果部分，用户选择的排序方式，
     * 取值为 {@link com.r948.utilities.Constants.SortKind}
     */
    private final MutableLiveData<String> sortKind = new MutableLiveData<>();

    /**
     * 推荐商品图片
     */
    private final MutableLiveData<List<List<String>>> commodityImage = new MutableLiveData<>();

    /**
     * 推荐商品名称
     */
    private final MutableLiveData<List<List<String>>> commodityName = new MutableLiveData<>();

    /**
     * 推荐商品单价
     */
    private final MutableLiveData<List<List<String>>> commodityPrice = new MutableLiveData<>();


    public SearchModel(Repository repo) {
        super(repo);
    }

    public MutableLiveData<List<ShowShop>> getShowShops() {
        return showShops;
    }

    public MutableLiveData<String> getSearch() {
        return search;
    }

    public MutableLiveData<String> getSortKind() {
        return sortKind;
    }

    public MutableLiveData<List<List<String>>> getCommodityImage() {
        return commodityImage;
    }

    public MutableLiveData<List<List<String>>> getCommodityName() {
        return commodityName;
    }

    public MutableLiveData<List<List<String>>> getCommodityPrice() {
        return commodityPrice;
    }
}
