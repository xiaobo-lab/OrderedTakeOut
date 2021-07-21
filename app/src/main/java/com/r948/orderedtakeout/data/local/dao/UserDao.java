package com.r948.orderedtakeout.data.local.dao;

import androidx.room.Dao;

import com.r948.orderedtakeout.data.model.User;

@Dao
public interface UserDao {
    User[] queryUsersByLoginInfo(String phone, String password);

    void addUser(User user);

    void delUser(User user);
}
