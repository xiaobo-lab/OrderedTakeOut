package com.r948.orderedtakeout.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "address", indices = {@Index(value = "address_id", unique = true)})
public class Address {
    @PrimaryKey
    @ColumnInfo(name = "address_id")
    public int addressId;

    @ColumnInfo(name = "user_id")
    public int userId;

    @ColumnInfo(name = "address_name")
    public String addressName;

    @ColumnInfo(name = "address_phone")
    public String addressPhone;

    @ColumnInfo(name = "address")
    public String address;

    public Address() { }

    @Ignore
    public Address(int addressId, int userId, String addressName, String addressPhone, String address) {
        this.addressId = addressId;
        this.userId = userId;
        this.addressName = addressName;
        this.addressPhone = addressPhone;
        this.address = address;
    }
}
