package com.r948.orderedtakeout.data.net.dao.django;

import com.r948.orderedtakeout.data.net.NetDataSource;
import com.r948.orderedtakeout.data.net.dao.UserDao;

public class DjangoNetDataSource extends NetDataSource {
    @Override
    public UserDao userDao() {
        return null;
    }
}
