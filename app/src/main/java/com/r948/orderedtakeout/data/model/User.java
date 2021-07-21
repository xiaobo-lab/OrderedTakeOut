package com.r948.orderedtakeout.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "user", indices = {@Index(value = "user_id", unique = true)})
public class User {
    @PrimaryKey
    @ColumnInfo(name = "user_id")
    public int userId;

    @ColumnInfo(name = "user_phone")
    public String userPhone;

    @ColumnInfo(name = "password")
    public String password;

    @ColumnInfo(name = "username")
    public String username;

    @ColumnInfo(name = "role")
    public byte role;

    public User() { }

    @Ignore
    public User(int userId, String userPhone, String password, String username, byte role) {
        this.userId = userId;
        this.userPhone = userPhone;
        this.password = password;
        this.username = username;
        this.role = role;
    }
}
