package com.r948.data.net.dao.django;

import com.r948.data.net.NetDataSource;
import com.r948.data.net.dao.AddressDao;
import com.r948.data.net.dao.CommodityDao;
import com.r948.data.net.dao.DeliverDao;
import com.r948.data.net.dao.OrderCommodityDao;
import com.r948.data.net.dao.OrderDao;
import com.r948.data.net.dao.ShopDao;
import com.r948.data.net.dao.UserDao;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DjangoNetDataSource implements NetDataSource {
    @Override
    public UserDao getUserDao() throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL("").openConnection();
        connection.getOutputStream().write("".getBytes());
        connection.setDoInput(true);
        return null;
    }

    @Override
    public ShopDao getShopDao() {
        return null;
    }

    @Override
    public OrderDao getOrderDao() {
        return null;
    }

    @Override
    public OrderCommodityDao getOrderCommodityDao() {
        return null;
    }

    @Override
    public DeliverDao getDeliverDao() {
        return null;
    }

    @Override
    public CommodityDao getCommodityDao() {
        return null;
    }

    @Override
    public AddressDao getAddressDao() {
        return null;
    }
}
