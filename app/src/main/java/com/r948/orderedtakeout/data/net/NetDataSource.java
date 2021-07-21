package com.r948.orderedtakeout.data.net;

import com.r948.orderedtakeout.data.net.dao.UserDao;

public abstract class NetDataSource {
    public abstract UserDao userDao();
}
