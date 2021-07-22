package com.r948.data.net.dao;

import com.r948.data.model.Order;

import org.json.JSONException;

import java.io.IOException;

public interface OrderDao {

    /**
     * 根据用户id查询订单
     *
     * @param userid
     * @return user_id符合的Order数组
     * @sql select * from order where user_id = :userid
     */
    Order[] findOrderByUserId(int userid)throws IOException, JSONException;

    /**
     * 根据商铺id查询订单
     *
     * @param shopId
     * @return shop_id符合的Order数组
     * @sql select * from order where shop_id = :shopId
     */
    Order[] findOrderByShopId(int shopId)throws IOException, JSONException;

    /**
     * 根据骑手id查询订单
     *
     * @param deliverId
     * @return deliver_id符合的Order数组
     * @sql select * from order where deliver_id = :deliverId
     */
    Order[] findOrderByDeliverId(int deliverId)throws IOException, JSONException;

    /**
     * 添加订单
     *
     * @param order
     * @return 受影响行数
     * @sql insert into `order`(address_id,deliver_id,shop_id,user_id,state)
            values(:order.addressId, :order.deliverId, :order.shopId, order.userId, :order.state)
     */
    int addOrder(Order order)throws IOException, JSONException;
}
