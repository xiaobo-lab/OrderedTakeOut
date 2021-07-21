package com.r948.data.net.dao;

import com.r948.data.model.Shop;

import org.json.JSONException;

import java.io.IOException;

public interface ShopDao {

    /**
     * 根据用户id查询店铺
     *
     * @param userId 用户id
     * @return user_id符合的Shop数组
     * @sql select * from `shop` where user_id = :userId
     */
    Shop[] findShopByUserId(int userId)throws IOException, JSONException;

    /**
     * 根据商铺id查找商铺
     *
     * @param shopId 商铺id
     * @return shop_id符合的Shop数组
     * @sql select * from `shop` where shop_id = :shopId
     */
    Shop[] findShopByShopId(int shopId)throws IOException, JSONException;

    /**
     * 根据商品类别查找店铺
     *
     * @param sort 商品类别,int
     * @return 有该类别商品的Shop数组
     * @sql select `shop`.* from `shop`,`commodity` where shop.shop_id = commodity.shop_id and commodity.sort = :sort
     */
    Shop[] findShopByCommSort(int sort)throws IOException, JSONException;

    /**
     * 添加店铺
     *
     * @param shop 需添加的Shop对象
     * @return 受影响行数
     * @sql insert into `shop`(user_id,shop_name,shop_lon,shop_lat,introduction,distance,state,shop_head_icon)
            values(:shop.userId, :shop.shopName, :shop.shopLon, :shop.shopLat, :shop.introduction,
            :shop.distance, :shop.state, :shop.shopHeadIcon);
     */
    int addShop(Shop shop)throws IOException, JSONException;

    /**
     * 更新店铺
     *
     * @param shop 需更新的Shop对象
     * @return 受影响行数
     * @sql update `shop` set user_id = :shop.userId, shop_name = :shop.shopName, shop_lon = :shop.shopLon,
            shop_lat = :shop.shopLat, introduction = :shop.introduction, distance = :shop.distance,
            state = :shop.state, shop_head_icon = :shop.shopHeadIcon where shop_id = :shop.shopId
     */
    int updateShop(Shop shop)throws IOException, JSONException;
}
