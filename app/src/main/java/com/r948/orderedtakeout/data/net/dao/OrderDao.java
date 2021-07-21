package com.r948.orderedtakeout.data.net.dao;

import com.r948.orderedtakeout.data.model.Order;
import com.r948.orderedtakeout.data.model.OrderCommodity;

public interface OrderDao {

    // select * from order where user_id = :userid
    Order[] findOrderByUserId(int userid);

    // select * from order where deliver_id = :deliverId
    Order[] findOrderByDeliverId(int deliverId);

    // insert
    int addOrder(Order order);

    // delete
    int deleteOrder(Order order);
}
