package com.r948.data;

import android.widget.RatingBar;

import androidx.lifecycle.MutableLiveData;

import com.r948.data.local.LocalDataSource;
import com.r948.data.model.Address;
import com.r948.data.model.Commodity;
import com.r948.data.model.Deliver;
import com.r948.data.model.Order;
import com.r948.data.model.OrderCommodity;
import com.r948.data.model.Shop;
import com.r948.data.model.User;
import com.r948.data.net.NetDataSource;
import com.r948.data.net.dao.AddressDao;
import com.r948.data.net.dao.CommodityDao;
import com.r948.data.net.dao.DeliverDao;
import com.r948.data.net.dao.OrderCommodityDao;
import com.r948.data.net.dao.OrderDao;
import com.r948.data.net.dao.ShopDao;
import com.r948.data.net.dao.UserDao;

import org.json.JSONException;

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
    //以下为 net.AddressDao的方法

    public Address findNetAddressByUserId(int userId) {
        Address[] addresses;
        if (userId <= 0) {
            message.postValue("userId 为0！(在AddressDao的findNetAddressByUserId方法)");
            return new Address(0, 0, "", "", 0.0, 0.0);
        }
        try {
            addresses = addressDao.findAddressByUserId(userId);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            message.postValue(e.getMessage());
            return new Address(0, 0, "", "", 0.0, 0.0);
        }
        return addresses.length == 1 ? addresses[0] : new Address(0, 0, "", "", 0.0, 0.0);
    }

    public boolean addNetAddress(Address address) {
        // 参数有效性检查
        if (address.userId <= 0 || address.addressName == null || address.addressPhone == null || address.addressLon == null || address.addressLat == null) {
            message.postValue("address的对象中有属性为null!--(在 AddressDao的addNetAddress方法)");
            return false;
        }
        int res = 0;
        try {
            res = addressDao.addAddress(address);
        } catch (IOException | JSONException e) {
            message.postValue(e.getMessage());
        }
        return res == 1;
    }

    public boolean deleteNetAddressById(int addressId) {
        // 参数有效性检查
        if (addressId <= 0) {
            message.postValue("删除的id为0!--(在 AddressDao的deleteNetAddressById方法)");
            return false;
        }
        int res = 0;
        try {
            res = addressDao.deleteAddressById(addressId);
        } catch (IOException | JSONException e) {
            message.postValue(e.getMessage());
        }
        return res == 1;
    }

    public boolean updateNetAddressById(Address address, int addressId) {
        // 参数有效性检查
        if (addressId <= 0) {
            message.postValue("删除的id为0!--(在 AddressDao的updateNetAddressById方法)");
            return false;
        } else if (address.userId <= 0 || address.addressName == null || address.addressPhone == null || address.addressLon == null || address.addressLat == null) {
            message.postValue("address的对象中有属性为null!--(在 AddressDao的updateNetAddressById方法)");
            return false;
        }
        int res = 0;
        try {
            res = addressDao.updateAddress(address, addressId);
        } catch (IOException | JSONException e) {
            message.postValue(e.getMessage());
        }
        return res == 1;
    }

    //以下为 net.CommodityDao的方法
    public Commodity findNetCommodityById(int commodityId) {
        Commodity[] commodities;
        if (commodityId <= 0) {
            message.postValue("id 为0！(在CommodityDao的findNetCommodityById方法)");
            return new Commodity(0, 0, "", (short) 0, 0.0f, 0.0f, 0, "");
        }
        try {
            commodities = commodityDao.findCommodityById(commodityId);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            message.postValue(e.getMessage());
            return new Commodity(0, 0, "", (short) 0, 0.0f, 0.0f, 0, "");
        }
        return commodities.length == 1 ? commodities[0] : new Commodity(0, 0, "", (short) 0, 0.0f, 0.0f, 0, "");
    }

    public Commodity findNetCommodityByShopId(int shopId) {
        Commodity[] commodities;
        if (shopId <= 0) {
            message.postValue("id 为0！(在CommodityDao的findNetCommodityByShopId方法)");
            return new Commodity(0, 0, "", (short) 0, 0.0f, 0.0f, 0, "");
        }
        try {
            commodities = commodityDao.findCommodityByShopId(shopId);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            message.postValue(e.getMessage());
            return new Commodity(0, 0, "", (short) 0, 0.0f, 0.0f, 0, "");
        }
        return commodities.length == 1 ? commodities[0] : new Commodity(0, 0, "", (short) 0, 0.0f, 0.0f, 0, "");
    }

    public boolean deleteNetCommodityById(int commodityId) {
        // 参数有效性检查
        if (commodityId <= 0) {
            message.postValue("删除的id为0!--(在 CommodityDao的deleteNetCommodityById方法)");
            return false;
        }
        int res = 0;
        try {
            res = commodityDao.deleteCommodityById(commodityId);
        } catch (IOException | JSONException e) {
            message.postValue(e.getMessage());
        }
        return res == 1;
    }

    public boolean updateNetCommodityById(Commodity commodity, int commodityId) {
        // 参数有效性检查
        if (commodityId <= 0) {
            message.postValue("删除的id为0!--(在 CommodityDao的updateNetCommodityById方法)");
            return false;
        } else if (commodity.shopId <= 0 || commodity.commName == null || commodity.sort >= 5 || commodity.price <= 0.0f || commodity.commScore < 0 || commodity.salesVolume < 0 || commodity.picture == null) {
            message.postValue("Commodity的对象中有属性为null!--(在 CommodityDao的updateNetCommodityById方法)");
            return false;
        }
        int res = 0;
        try {
            res = commodityDao.updateCommodity(commodity, commodityId);
        } catch (IOException | JSONException e) {
            message.postValue(e.getMessage());
        }
        return res == 1;
    }

    public boolean addNetCommodity(Commodity commodity) {
        // 参数有效性检查
        if (commodity.shopId <= 0 || commodity.commName == null || commodity.sort >= 5 || commodity.price <= 0.0f || commodity.commScore < 0 || commodity.salesVolume < 0 || commodity.picture == null) {
            message.postValue("commodity的对象中有属性为null!--(在 CommodityDao的addNetCommodity方法)");
            return false;
        }
        int res = 0;
        try {
            res = commodityDao.addCommodity(commodity);
        } catch (IOException | JSONException e) {
            message.postValue(e.getMessage());
        }
        return res == 1;
    }

    //以下是net.DeliverDao的方法
    public Deliver findNetDeliverByUserId(int userId) {
        Deliver[] delivers;
        if (userId <= 0) {
            message.postValue("id 为0！(在deliverDao的findNetDeliverByUserId方法)");
            return new Deliver(0, 0, 0.0f, 0);
        }
        try {
            delivers = deliverDao.findDeliverByUserId(userId);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            message.postValue(e.getMessage());
            return new Deliver(0, 0, 0.0f, 0);
        }
        return delivers.length == 1 ? delivers[0] : new Deliver(0, 0, 0.0f, 0);
    }

    public Deliver findNetDeliverByDeliverId(int deliverId) {
        Deliver[] delivers;
        if (deliverId <= 0) {
            message.postValue("id 为0！(在deliverDao的findNetDeliverByDeliverId方法)");
            return new Deliver(0, 0, 0.0f, 0);
        }
        try {
            delivers = deliverDao.findDeliverByUserId(deliverId);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            message.postValue(e.getMessage());
            return new Deliver(0, 0, 0.0f, 0);
        }
        return delivers.length == 1 ? delivers[0] : new Deliver(0, 0, 0.0f, 0);
    }

    //以下是net.OrderCommodityDao的方法
    public OrderCommodity[] findNetOderCommodityByOrderId(int orderId) {
        OrderCommodity[] orderCommodities;
        if (orderId <= 0) {
            message.postValue("id 为0！(在orderCommodityDao的findNetOderCommodityByOrderId方法)");
            return new OrderCommodity[0];
        }
        try {
            orderCommodities = orderCommodityDao.findOrderCommodityByOrderId(orderId);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            message.postValue(e.getMessage());
            return new OrderCommodity[0];
        }
        return orderCommodities.length >= 1 ? orderCommodities : new OrderCommodity[0];
    }

    public boolean addNetOrderCommodity(OrderCommodity orderCommodity) {
        // 参数有效性检查
        if (orderCommodity.commodityId <= 0 || orderCommodity.orderId <= 0 || orderCommodity.quantity < 0) {
            message.postValue("orderCommodity的对象中有属性为null!--(在 orderCommodityDao的addNetOrderCommodity方法)");
            return false;
        }
        int res = 0;
        try {
            res = orderCommodityDao.addOrderCommodity(orderCommodity);
        } catch (IOException | JSONException e) {
            message.postValue(e.getMessage());
        }
        return res == 1;
    }

    //以下是net.OrderDao的
    public Order[] findNetOrderByUserId(int userId) {
        Order[] orders;
        if (userId <= 0) {
            message.postValue("id 为0！(在orderDao的findNetOrderByUserId方法)");
            return new Order[0];
        }
        try {
            orders = orderDao.findOrderByUserId(userId);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            message.postValue(e.getMessage());
            return new Order[0];
        }
        return orders.length >= 1 ? orders : new Order[0];
    }

    public Order[] findNetOrderByShopId(int shopId) {
        Order[] orders;
        if (shopId <= 0) {
            message.postValue("id 为0！(在orderDao的findNetOrderByShopId方法)");
            return new Order[0];
        }
        try {
            orders = orderDao.findOrderByShopId(shopId);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            message.postValue(e.getMessage());
            return new Order[0];
        }
        return orders.length >= 1 ? orders : new Order[0];
    }

    public Order[] findNetOrderByDeliverId(int deliverId) {
        Order[] orders;
        if (deliverId <= 0) {
            message.postValue("id 为0！(在orderDao的findNetOrderByDeliverId方法)");
            return new Order[0];
        }
        try {
            orders = orderDao.findOrderByDeliverId(deliverId);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            message.postValue(e.getMessage());
            return new Order[0];
        }
        return orders.length >= 1 ? orders : new Order[0];
    }

    public boolean addNetOrder(Order order) {
        // 参数有效性检查
        if (order.addressId <= 0 || order.deliverId <= 0 || order.shopId <= 0 || order.userId <= 0 || order.state < 0 || order.state > 2 || order.orderTime == null) {
            message.postValue("order的对象中有属性为null!--(在 orderDao的addNetOrder方法)");
            return false;
        }
        int res = 0;
        try {
            res = orderDao.addOrder(order);
        } catch (IOException | JSONException e) {
            message.postValue(e.getMessage());
        }
        return res == 1;
    }

    public Shop findNetShopByShopId(int shopId) {
        Shop[] shops;
        if (shopId <= 0) {
            message.postValue("id 为0！(在ShopDao的findNetShopByShopId方法)");
            return new Shop(0, 0, "", 0.0, 0.0, "", 0, (byte) 0, "");
        }
        try {
            shops = shopDao.findShopByShopId(shopId);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            message.postValue(e.getMessage());
            return new Shop(0, 0, "", 0.0, 0.0, "", 0, (byte) 0, "");
        }
        return shops.length == 1 ? shops[0] : new Shop(0, 0, "", 0.0, 0.0, "", 0, (byte) 0, "");
    }

    public Shop findNetShopByUserId(int userId) {
        Shop[] shops;
        if (userId <= 0) {
            message.postValue("id 为0！(在ShopDao的findNetShopByUserId方法)");
            return new Shop(0, 0, "", 0.0, 0.0, "", 0, (byte) 0, "");
        }
        try {
            shops = shopDao.findShopByUserId(userId);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            message.postValue(e.getMessage());
            return new Shop(0, 0, "", 0.0, 0.0, "", 0, (byte) 0, "");
        }
        return shops.length == 1 ? shops[0] : new Shop(0, 0, "", 0.0, 0.0, "", 0, (byte) 0, "");
    }

    public Shop[] findNetShopByCommSort(int sort) {
        Shop[] shops;
        if (sort <= 0) {
            message.postValue("id 为0！(在ShopDao的findNetShopByCommSort方法)");
            return new Shop[0];
        }
        try {
            shops = shopDao.findShopByCommSort(sort);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            message.postValue(e.getMessage());
            return new Shop[0];
        }
        return shops.length >= 1 ? shops : new Shop[0];
    }

    public boolean addNetShop(Shop shop) {
        // 参数有效性检查
        if (shop.userId <= 0 || shop.shopName == null || shop.shopHeadIcon == null || shop.introduction == null || shop.distance == 0 || shop.state < 0 || shop.state > 1) {
            message.postValue("shop的对象中有属性为null!--(在 shopDao的addNetShop方法)");
            return false;
        }
        int res = 0;
        try {
            res = shopDao.addShop(shop);
        } catch (IOException | JSONException e) {
            message.postValue(e.getMessage());
        }
        return res == 1;
    }

    public boolean updateNetShop(Shop shop) {
        // 参数有效性检查
        if (shop.shopId <= 0 || shop.userId <= 0 || shop.shopName == null || shop.shopHeadIcon == null || shop.introduction == null || shop.distance == 0 || shop.state < 0 || shop.state > 1) {
            message.postValue("shop的对象中有属性为null!--(在 shopDao的updateNetShop方法)");
            return false;
        }
        int res = 0;
        try {
            res = shopDao.updateShop(shop);
        } catch (IOException | JSONException e) {
            message.postValue(e.getMessage());
        }
        return res == 1;
    }

    public User findNetUserByPhone(String phone) {
        User[] users;
        if (phone == null) {
            message.postValue("id 为0！(在UserDao的findNetUserByPhone方法)");
            return new User(0, "", "", "", (byte) -1, "");
        }
        try {
            users = userDao.findUserByPhone(phone);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            message.postValue(e.getMessage());
            return new User(0, "", "", "", (byte) -1, "");
        }
        return users.length == 1 ? users[0] : new User(0, "", "", "", (byte) -1, "");
    }

    public User queryNetUsersByLoginInfo(String phone, String password) {
        User[] users;
        if (phone == null || password == null) {
            message.postValue("id 为0！(在UserDao的queryNetUsersByLoginInfo方法)");
            return new User(0, "", "", "", (byte) -1, "");
        }
        try {
            users = userDao.queryUsersByLoginInfo(phone, password);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            message.postValue(e.getMessage());
            return new User(0, "", "", "", (byte) -1, "");
        }
        return users.length == 1 ? users[0] : new User(0, "", "", "", (byte) -1, "");
    }

    public boolean updateNetUser(User user) {
        // 参数有效性检查
        if (user.userId <= 0 || user.userPhone == null || user.password == null || user.username == null || user.userHeadIcon == null || user.role < 0 || user.role > 2) {
            message.postValue("user的对象中有属性为null!--(在 userDao的updateNetUser方法)");
            return false;
        }
        int res = 0;
        try {
            res = userDao.updateUser(user);
        } catch (IOException | JSONException e) {
            message.postValue(e.getMessage());
        }
        return res == 1;
    }
    public boolean addNetUser(User user){
        // 参数有效性检查
        if (user.userPhone == null || user.password == null || user.username == null || user.userHeadIcon == null || user.role < 0 || user.role > 2) {
            message.postValue("user的对象中有属性为null!--(在 userDao的addNetUser方法)");
            return false;
        }
        int res = 0;
        try {
            res = userDao.addUser(user);
        } catch (IOException | JSONException e) {
            message.postValue(e.getMessage());
        }
        return res == 1;
    }
    //以下是Local.AddressDao的方法
    public Address findLocalAddressByUserId(int userId) {
        Address[] addresses;
        if (userId <= 0) {
            message.postValue("userId 为0！(在AddressDao的findLocalAddressByUserId方法)");
            return new Address(0, 0, "", "", 0.0, 0.0);
        }
        try {
            addresses = localAddressDao.findAddressByUserId(userId);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            message.postValue(e.getMessage());
            return new Address(0, 0, "", "", 0.0, 0.0);
        }
        return addresses.length == 1 ? addresses[0] : new Address(0, 0, "", "", 0.0, 0.0);
    }

    public boolean addLocalAddress(Address address) {
        // 参数有效性检查
        if (address.userId <= 0 || address.addressName == null || address.addressPhone == null || address.addressLon == null || address.addressLat == null) {
            message.postValue("address的对象中有属性为null!--(在 AddressDao的addLocalAddress方法)");
            return false;
        }
        try {
            localAddressDao.addAddress(address);
        } catch (IOException | JSONException e) {
            message.postValue(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean deleteLocalAddressById(int addressId) {
        if (addressId <= 0) {
            message.postValue("address的对象中有属性为null!--(在 AddressDao的deleteLocalAddressById方法)");
            return false;
        }
        try {
            localAddressDao.deleteAddressById(addressId);
        } catch (IOException | JSONException e) {
            message.postValue(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean updateLocalAddress(Address address) {
        // 参数有效性检查
        if (address.addressId <= 0 || address.userId <= 0 || address.addressName == null || address.addressPhone == null || address.addressLon == null || address.addressLat == null) {
            message.postValue("address的对象中有属性为null!--(在 AddressDao的addLocalAddress方法)");
            return false;
        }
        try {
            localAddressDao.updateAddress(address);
        } catch (IOException | JSONException e) {
            message.postValue(e.getMessage());
            return false;
        }
        return true;
    }
    //以下是LocalUserDao的方法
    public User queryLocalUsersByLoginInfo(String phone, String password) {
        User[] users;
        if (phone == null || password == null) {
            message.postValue("id 为0！(在UserDao的queryNetUsersByLoginInfo方法)");
            return new User(0, "", "", "", (byte) -1, "");
        }
        try {
            users = localUserDao.queryUsersByLoginInfo(phone, password);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            message.postValue(e.getMessage());
            return new User(0, "", "", "", (byte) -1, "");
        }
        return users.length == 1 ? users[0] : new User(0, "", "", "", (byte) -1, "");
    }
    public boolean addLocalUser(User user){
        // 参数有效性检查
        if (user.userPhone==null||user.password==null||user.userHeadIcon==null||user.role<0||user.role>2) {
            message.postValue("address的对象中有属性为null!--(在 UserDao的addLocalUser方法)");
            return false;
        }
        try {
            localUserDao.addUser(user);
        } catch (IOException | JSONException e) {
            message.postValue(e.getMessage());
            return false;
        }
        return true;
    }
}
