package com.r948.data.net.dao.django;

import com.r948.data.model.Order;
import com.r948.data.net.dao.OrderDao;
import com.r948.utilities.HttpUtil;
import com.r948.utilities.StringUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class DjangoOrderDao implements OrderDao {

    private final String url;

    public DjangoOrderDao(String url) {
        this.url = url;
    }

    @Override
    public Order[] findOrderByUserId(int userid) throws IOException, JSONException {
        JSONObject result = new JSONObject(HttpUtil.sendHttpPostRequest(url, "find_order_by_id", new JSONObject()
                .put("user_id", userid).toString()));
        String error = result.getString("error");
        if (!StringUtil.haveNullOrEmpty(error)) {
            throw new IOException(error);
        }
        JSONArray data = result.getJSONArray("data");
        Order[] orders = new Order[data.length()];
        for (int i = 0, len = data.length(); i < len; i++) {
            JSONArray t = data.getJSONArray(i);
            orders[i] = new Order(t.getInt(0), t.getInt(1), t.getInt(2),
                    t.getInt(3), t.getInt(4), (byte) t.getInt(5), t.getString(6));
        }
        return orders;
    }

    @Override
    public Order[] findOrderByShopId(int shopId) throws IOException, JSONException {
        JSONObject result = new JSONObject(HttpUtil.sendHttpPostRequest(url, "find_order_by_shop_id", new JSONObject()
                .put("shop_id", shopId).toString()));
        String error = result.getString("error");
        if (!StringUtil.haveNullOrEmpty(error)) {
            throw new IOException(error);
        }
        JSONArray data = result.getJSONArray("data");
        Order[] orders = new Order[data.length()];
        for (int i = 0, len = data.length(); i < len; i++) {
            JSONArray t = data.getJSONArray(i);
            orders[i] = new Order(t.getInt(0), t.getInt(1), t.getInt(2),
                    t.getInt(3), t.getInt(4), (byte) t.getInt(5), t.getString(6));
        }
        return orders;
    }

    @Override
    public Order[] findOrderByDeliverId(int deliverId) throws IOException, JSONException {
        JSONObject result = new JSONObject(HttpUtil.sendHttpPostRequest(url, "find_order_by_deliver_id", new JSONObject()
                .put("deliver_id", deliverId).toString()));
        String error = result.getString("error");
        if (!StringUtil.haveNullOrEmpty(error)) {
            throw new IOException(error);
        }
        JSONArray data = result.getJSONArray("data");
        Order[] orders = new Order[data.length()];
        for (int i = 0, len = data.length(); i < len; i++) {
            JSONArray t = data.getJSONArray(i);
            orders[i] = new Order(t.getInt(0), t.getInt(1), t.getInt(2),
                    t.getInt(3), t.getInt(4), (byte) t.getInt(5), t.getString(6));
        }
        return orders;
    }

    @Override
    public int addOrder(Order order) throws IOException, JSONException {
        JSONObject result = new JSONObject(HttpUtil.sendHttpPostRequest(url, "add_order", new JSONObject()
                .put("order_id", order.orderId).put("address_id", order.addressId)
                .put("deliver_id", order.deliverId).put("shop_id", order.shopId)
                .put("user_id", order.userId).put("state", order.state)
                .put("order_time", order.orderTime).toString()));
        String error = result.getString("error");
        if (!StringUtil.haveNullOrEmpty(error)) {
            throw new IOException(error);
        }
        return result.getInt("affected");
    }
}
