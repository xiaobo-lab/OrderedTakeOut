package com.r948.orderedtakeout.data.model;

public class Commodity {
    public int commodityId;
    public int shopId;
    public String commName;
    public short sort;
    public float price;
    public float commScore;
    public int salesVolume;
    public String picture;

    public Commodity() { }

    public Commodity(int commodityId, int shopId, String commName, short sort, float price, float commScore, int salesVolume, String picture) {
        this.commodityId = commodityId;
        this.shopId = shopId;
        this.commName = commName;
        this.sort = sort;
        this.price = price;
        this.commScore = commScore;
        this.salesVolume = salesVolume;
        this.picture = picture;
    }
}
