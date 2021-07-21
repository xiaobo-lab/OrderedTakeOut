package com.r948.orderedtakeout.data.local.dao;

import androidx.room.Dao;

import com.r948.orderedtakeout.data.model.User;

@Dao
public interface UserDao {
    /**
     * 应用场景：登录、个人信息
     *
     * @param phone
     * @param password
     * @return 一条用户信息
     * @sql select *from user where user_phone =: phone and password =: password;
     */
    User[] queryUsersByLoginInfo(String phone, String password);

    /**
     * 应用场景：注册用户
     *
     * @param user
     * @sql insert into user (user_phone,password,username,user_head_icon,role) values(user.userPhone,user.password,user.username,userHeadIcon,role);
     */
    void addUser(User user);
}
