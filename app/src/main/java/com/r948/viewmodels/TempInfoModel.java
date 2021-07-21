package com.r948.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.r948.models.Cart;

import java.util.List;

/**
 * 用户操作产生的临时信息
 */
public class TempInfoModel extends ViewModel {
    /**
     * 用户输入的搜索信息
     */
    private final MutableLiveData<String> search = new MutableLiveData<>();

    /**
     * 外卖页中推荐商家部分，用户选择的排序方式，
     * 取值为 {@link com.r948.utilities.Constants.SortKind}
     */
    private final MutableLiveData<String> takeoutSortKind = new MutableLiveData<>();

    /**
     * 搜索结果页中搜索结果部分，用户选择的排序方式，
     * 取值为 {@link com.r948.utilities.Constants.SortKind}
     */
    private final MutableLiveData<String> searchSortKind = new MutableLiveData<>();

    /**
     * 购物车数据
     */
    private final MutableLiveData<List<Cart>> shoppingCart = new MutableLiveData<>();

    public MutableLiveData<String> getSearch() {
        return search;
    }

    public MutableLiveData<String> getTakeoutSortKind() {
        return takeoutSortKind;
    }

    public MutableLiveData<String> getSearchSortKind() {
        return searchSortKind;
    }

    public MutableLiveData<List<Cart>> getShoppingCart() {
        return shoppingCart;
    }
}
