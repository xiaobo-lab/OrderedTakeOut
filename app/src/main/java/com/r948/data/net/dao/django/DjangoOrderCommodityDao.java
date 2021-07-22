package com.r948.data.net.dao.django;

import com.r948.data.model.OrderCommodity;
import com.r948.data.net.dao.OrderCommodityDao;
import com.r948.utilities.HttpUtil;
import com.r948.utilities.StringUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class DjangoOrderCommodityDao implements OrderCommodityDao {

    private final String url;

    public DjangoOrderCommodityDao(String url) {
        this.url = url;
    }

    @Override
    public OrderCommodity[] findOrderCommodityByOrderId(int orderId) throws IOException, JSONException {
        JSONObject result = new JSONObject(HttpUtil.sendHttpPostRequest(url, "find_order_commodity_by_order_id", new JSONObject()
                .put("order_id", orderId).toString()));
        String error = result.getString("error");
        if (!StringUtil.haveNullOrEmpty(error)) {
            throw new IOException(error);
        }
        JSONArray data = result.getJSONArray("data");
        OrderCommodity[] orderCommodities = new OrderCommodity[data.length()];
        for (int i = 0, len = data.length(); i < len; i++) {
            JSONArray t = data.getJSONArray(i);
            orderCommodities[i] = new OrderCommodity(t.getInt(0), t.getInt(1), t.getInt(2));
        }
        return orderCommodities;
    }

    @Override
    public int addOrderCommodity(OrderCommodity orderCommodity) throws IOException, JSONException {
        JSONObject result = new JSONObject(HttpUtil.sendHttpPostRequest(url, "add_order_commodity", new JSONObject()
                .put("order_id", orderCommodity.orderId).put("commodity_id", orderCommodity.commodityId)
                .put("quantity", orderCommodity.quantity).toString()));
        String error = result.getString("error");
        if (!StringUtil.haveNullOrEmpty(error)) {
            throw new IOException(error);
        }
        return result.getInt("affected");
    }
}
