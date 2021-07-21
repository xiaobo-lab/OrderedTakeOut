package com.r948.data.model;

public class Shop {
    public int shopId;
    public int userId;
    public String shopName;
    public double shopLon;
    public double shopLat;
    public String introduction;
    public int distance;
    public byte state;
    public String shopHeadIcon;

    public Shop() { }

    public Shop(int shopId, int userId, String shopName, double shopLon, double shopLat, String introduction, int distance, byte state, String shopHeadIcon) {
        this.shopId = shopId;
        this.userId = userId;
        this.shopName = shopName;
        this.shopLon = shopLon;
        this.shopLat = shopLat;
        this.introduction = introduction;
        this.distance = distance;
        this.state = state;
        this.shopHeadIcon = shopHeadIcon;
    }
}
