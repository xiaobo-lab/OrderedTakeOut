package com.r948.orderedtakeout.data.model;

public class Shop {
    public int shopId;
    public int userId;
    public String shopName;
    public String location;
    public String introduction;
    public int distance;
    public byte state;
    public String shopHeadIcon;

    public Shop() { }

    public Shop(int shopId, int userId, String shopName, String location, String introduction, int distance, byte state, String shopHeadIcon) {
        this.shopId = shopId;
        this.userId = userId;
        this.shopName = shopName;
        this.location = location;
        this.introduction = introduction;
        this.distance = distance;
        this.state = state;
        this.shopHeadIcon = shopHeadIcon;
    }
}
