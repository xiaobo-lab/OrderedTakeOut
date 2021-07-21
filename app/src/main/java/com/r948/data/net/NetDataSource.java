package com.r948.data.net;

import com.r948.data.net.dao.UserDao;

public abstract class NetDataSource {
    public abstract UserDao userDao();
}
