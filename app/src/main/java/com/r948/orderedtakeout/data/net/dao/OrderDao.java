package com.r948.orderedtakeout.data.net.dao;

import com.r948.orderedtakeout.data.model.Order;
import com.r948.orderedtakeout.data.model.OrderCommodity;

public interface OrderDao {

    /**
     *
     * 根据用户id查询订单
     *
     * @param userid
     * @return user_id符合的Order数组
     * @sql select * from order where user_id = :userid
     */
    Order[] findOrderByUserId(int userid);

    /**
     *
     * 根据骑手id查询订单
     *
     * @param deliverId
     * @return deliver_id符合的Order数组
     * @sql select * from order where deliver_id = :deliverId
     */
    Order[] findOrderByDeliverId(int deliverId);

    // insert
    int addOrder(Order order);

    // delete
    int deleteOrder(Order order);
}
