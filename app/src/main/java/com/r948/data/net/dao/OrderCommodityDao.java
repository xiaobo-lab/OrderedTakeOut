package com.r948.data.net.dao;

import com.r948.data.model.OrderCommodity;

import org.json.JSONException;

import java.io.IOException;

public interface OrderCommodityDao {
    /**
     *
     * 应用场景：查看订单详情
     * @param orderId
     * @return 订单中的所有商品，有多条
     * @sql select * from order_commodity where order_id =: orderId;
     */

    OrderCommodity[] findOrderCommodityByOrderId(int orderId) throws IOException, JSONException;

    /**
     *
     * 插入一条订单商品数据
     * 应用场景：订单结算
     * @param orderCommodity
     * @return 受影响的行数
     * @sql insert into order_commodity (order_id,commodity_id,quantity) values(orderCommodity.orderId,orderCommodity.commodityId,orderCommodity.quantity);
     */

    int addOrderCommodity(OrderCommodity orderCommodity)throws IOException, JSONException;
}
