package com.r948.data.net.dao;

import com.r948.data.model.User;

import org.json.JSONException;

import java.io.IOException;

public interface UserDao {

    /**
     * 根据手机号查找用户
     *
     * @param userPhone 手机号
     * @return 手机号符合的User数组
     * @sql select * from `user` where user_phone = :userPhone
     */
    User[] findUserByPhone(String userPhone) throws JSONException, IOException;

    /**
     * 根据手机号和密码查找用户
     *
     * @param phone    手机号
     * @param password 密码
     * @return 手机号和密码正确的User数组
     * @sql select * from `user` where user_phone = :userPhone and password = :password
     */
    User[] queryUsersByLoginInfo(String phone, String password);

    /**
     * 更新用户
     *
     * @param user 需更新的User对象
     * @return 受影响行数
     * @sql update `user` set user_phone = :user.userPhone, password = :user.password, username = :user.username, user_head_icon = :user.userHeadIcon, role = :user.role where user_id = user.userId
     */
    int updateUser(User user);
}
