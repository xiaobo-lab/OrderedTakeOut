package com.r948.data.net;

import com.r948.data.net.dao.AddressDao;
import com.r948.data.net.dao.CommodityDao;
import com.r948.data.net.dao.DeliverDao;
import com.r948.data.net.dao.OrderCommodityDao;
import com.r948.data.net.dao.OrderDao;
import com.r948.data.net.dao.ShopDao;
import com.r948.data.net.dao.UserDao;

public interface NetDataSource {
    UserDao getUserDao();

    ShopDao getShopDao();

    OrderDao getOrderDao();

    OrderCommodityDao getOrderCommodityDao();

    DeliverDao getDeliverDao();

    CommodityDao getCommodityDao();

    AddressDao getAddressDao();
}
