package com.r948.orderedtakeout.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;

@Entity(tableName = "user_address", primaryKeys = {"user_id", "address_id"})
public class UserAddress {
    @ColumnInfo(name = "user_id")
    public int userId;

    @ColumnInfo(name = "address_id")
    public int addressId;

    public UserAddress() { }

    @Ignore
    public UserAddress(int userId, int addressId) {
        this.userId = userId;
        this.addressId = addressId;
    }
}
