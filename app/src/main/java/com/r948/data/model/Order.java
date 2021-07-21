package com.r948.data.model;

public class Order {
    public int orderId;
    public int addressId;
    public int deliverId;
    public int shopId;
    public int userId;
    public byte state;
    public String orderTime;

    public Order() { }

    public Order(int orderId, int addressId, int deliverId, int shopId, int userId, byte state, String orderTime) {
        this.orderId = orderId;
        this.addressId = addressId;
        this.deliverId = deliverId;
        this.shopId = shopId;
        this.userId = userId;
        this.state = state;
        this.orderTime = orderTime;
    }
}
