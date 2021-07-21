package com.r948.orderedtakeout.data.net.dao;

import com.r948.orderedtakeout.data.model.Shop;

public interface ShopDao {

    // select * from shop where user_id = :id
    Shop[] findShopByUserId(int id);

    // inset
    int addShop(Shop shop);

    // update
    int updateShop(Shop shop);

    // delete
    int deleteShop(Shop shop);
}
