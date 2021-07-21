package com.r948.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.r948.data.model.User;

@Dao
public interface UserDao {
    /**
     * 应用场景：登录、个人信息查询和管理
     *
     * @param phone    phone
     * @param password password
     * @return 一条用户信息
     */
    @Query("select *from user where user_phone =:phone and password =:password")
    User[] queryUsersByLoginInfo(String phone, String password);

    /**
     * 应用场景：注册用户
     *
     * @param user user
     */
    @Insert
    void addUser(User user);
}
