package com.r948.orderedtakeout.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;

import com.r948.orderedtakeout.data.model.User;

@Dao
public interface UserDao {
//    User[] queryUsersByLoginInfo(String phone, String password);

    @Insert
    void addUser(User user);

    @Delete
    void delUser(User user);
}
