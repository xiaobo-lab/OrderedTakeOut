package com.r948.orderedtakeout.data.net.dao.django;

import com.r948.orderedtakeout.data.net.DataSource;
import com.r948.orderedtakeout.data.net.dao.UserDao;

public class DjangoDataSource extends DataSource {
    @Override
    public UserDao userDao() {
        return null;
    }
}
