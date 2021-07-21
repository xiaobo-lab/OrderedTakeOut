package com.r948.orderedtakeout.data.net.dao;

import com.r948.orderedtakeout.data.model.User;

public interface UserDao {

    // select * from user where user_phone = :userPhone
    User[] findUserByPhone(String userPhone);

    // select * from user where user_phone = :userPhone and password = :password
    User[] queryUsersByLoginInfo(String phone, String password);

    // update
    int updateUser(User user);

    // delete
    int deleteUser(User user);
}
