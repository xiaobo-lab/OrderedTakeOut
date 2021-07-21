package com.r948.orderedtakeout.data.model;

public class Deliver {
    public int deliverId;
    public int userId;
    public float deliverScore;
    public int deliverNum;

    public Deliver() { }

    public Deliver(int deliverId, int userId, float deliverScore, int deliverNum) {
        this.deliverId = deliverId;
        this.userId = userId;
        this.deliverScore = deliverScore;
        this.deliverNum = deliverNum;
    }
}
