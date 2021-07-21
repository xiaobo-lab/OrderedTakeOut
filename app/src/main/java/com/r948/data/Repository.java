package com.r948.data;

import androidx.lifecycle.MutableLiveData;

import com.r948.data.local.LocalDataSource;
import com.r948.data.model.Address;
import com.r948.data.net.NetDataSource;
import com.r948.data.net.dao.AddressDao;
import com.r948.data.net.dao.CommodityDao;
import com.r948.data.net.dao.DeliverDao;
import com.r948.data.net.dao.OrderCommodityDao;
import com.r948.data.net.dao.OrderDao;
import com.r948.data.net.dao.ShopDao;
import com.r948.data.net.dao.UserDao;

import java.io.IOException;

public class Repository {
    private final MutableLiveData<String> message;
    private final com.r948.data.local.dao.AddressDao localAddressDao;
    private final com.r948.data.local.dao.UserDao localUserDao;
    private final AddressDao addressDao;
    private final CommodityDao commodityDao;
    private final DeliverDao deliverDao;
    private final OrderCommodityDao orderCommodityDao;
    private final OrderDao orderDao;
    private final ShopDao shopDao;
    private final UserDao userDao;

    public Repository(LocalDataSource localDataSource, NetDataSource netDataSource, MutableLiveData<String> message) {
        this.message = message;
        localUserDao = localDataSource.getUserDao();
        localAddressDao = localDataSource.getAddressDao();
        addressDao = netDataSource.getAddressDao();
        commodityDao = netDataSource.getCommodityDao();
        deliverDao = netDataSource.getDeliverDao();
        orderCommodityDao = netDataSource.getOrderCommodityDao();
        orderDao = netDataSource.getOrderDao();
        shopDao = netDataSource.getShopDao();
        userDao = netDataSource.getUserDao();
    }

    public boolean addNetAddress(Address address) {
        // 参数有效性检查
        int res = 0;
        try {
            res = addressDao.addAddress(address);
        } catch (IOException e) {
            message.postValue(e.getMessage());
        }
        return res == 1;
    }


}
