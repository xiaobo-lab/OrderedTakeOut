package com.r948.data.net.dao.django;

import com.r948.data.net.NetDataSource;
import com.r948.data.net.dao.UserDao;

public class DjangoNetDataSource extends NetDataSource {
    @Override
    public UserDao userDao() {
        return null;
    }
}
