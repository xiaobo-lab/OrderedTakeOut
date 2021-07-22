package com.r948.viewmodels.takeout.sort.shop.order;

import androidx.lifecycle.MutableLiveData;

import com.r948.data.Repository;
import com.r948.models.Cart;
import com.r948.models.ShowCommodity;
import com.r948.viewmodels.RepoViewModel;

import java.util.List;

/**
 * 店铺-点餐
 */
public class ShopOrderModel extends RepoViewModel {
    /**
     * 商品列表
     */
    private final MutableLiveData<List<ShowCommodity>> showCommodityList = new MutableLiveData<>();

    /**
     * 总价
     */
    private final MutableLiveData<Float> totalPrice = new MutableLiveData<>();

    /**
     * 购物车
     */
    private final MutableLiveData<List<Cart>> showCartList = new MutableLiveData<>();

    public ShopOrderModel(Repository repo, MutableLiveData<String> toastMsg) {
        super(repo, toastMsg);
    }

    public MutableLiveData<List<ShowCommodity>> getShowCommodityList() {
        return showCommodityList;
    }

    public MutableLiveData<Float> getTotalPrice() {
        return totalPrice;
    }

    public MutableLiveData<List<Cart>> getShowCartList() {
        return showCartList;
    }
}
