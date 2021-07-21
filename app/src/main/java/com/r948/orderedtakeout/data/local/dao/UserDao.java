package com.r948.orderedtakeout.data.local.dao;

import androidx.room.Dao;

import com.r948.orderedtakeout.data.model.User;

@Dao
public interface UserDao {
    //select *from user where user_phone =: phone and password =: password;
    User[] queryUsersByLoginInfo(String phone, String password);
    //add
    void addUser(User user);
    //delete
    void delUser(User user);
}
