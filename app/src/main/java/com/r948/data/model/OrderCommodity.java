package com.r948.data.model;

public class OrderCommodity {
    public int orderId;
    public int commodityId;
    public int quantity;

    public OrderCommodity() { }

    public OrderCommodity(int orderId, int commodityId, int quantity) {
        this.orderId = orderId;
        this.commodityId = commodityId;
        this.quantity = quantity;
    }
}
