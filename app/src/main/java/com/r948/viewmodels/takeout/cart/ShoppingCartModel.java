package com.r948.viewmodels.takeout.cart;

import androidx.lifecycle.MutableLiveData;

import com.r948.data.Repository;
import com.r948.models.Cart;
import com.r948.viewmodels.RepoViewModel;

import java.util.List;

/**
 * 购物车
 */
public class ShoppingCartModel extends RepoViewModel {
    /**
     * 商家名称
     */
    private final MutableLiveData<String> shopName = new MutableLiveData<>();

    /**
     * 购物信息
     */
    private final MutableLiveData<List<Cart>> shoppingCart = new MutableLiveData<>();

    public ShoppingCartModel(Repository repo) {
        super(repo);
    }

    public MutableLiveData<List<Cart>> getShoppingCart() {
        return shoppingCart;
    }

    public MutableLiveData<String> getShopName() {
        return shopName;
    }
}
