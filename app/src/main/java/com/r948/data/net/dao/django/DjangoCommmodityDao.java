package com.r948.data.net.dao.django;

import com.r948.data.model.Commodity;
import com.r948.data.net.dao.CommodityDao;
import com.r948.utilities.HttpUtil;
import com.r948.utilities.StringUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class DjangoCommmodityDao implements CommodityDao {

    private final String url;

    public DjangoCommmodityDao(String url) {
        this.url = url;
    }

    @Override
    public Commodity[] findCommodityById(int commodityId) throws IOException, JSONException {
        JSONObject result = new JSONObject(HttpUtil.sendHttpPostRequest(url, "find_commodity_by_id", new JSONObject()
                .put("commodity_id", commodityId).toString()));
        String error = result.getString("error");
        if (!StringUtil.haveNullOrEmpty(error)) {
            throw new IOException(error);
        }
        JSONArray data = result.getJSONArray("data");
        Commodity[] commodities = new Commodity[data.length()];
        for (int i = 0, len = data.length(); i < len; i++) {
            JSONArray t = data.getJSONArray(i);
            commodities[i] = new Commodity(t.getInt(0), t.getInt(1), t.getString(2),
                    (short) t.getInt(3), (float) t.getDouble(4), (float) t.getDouble(5),
                    t.getInt(6), t.getString(7));
        }
        return commodities;
    }

    @Override
    public Commodity[] findCommodityByShopId(int shopId) throws IOException, JSONException {
        JSONObject result = new JSONObject(HttpUtil.sendHttpPostRequest(url, "find_commodity_by_shop_id", new JSONObject()
                .put("shop_id", shopId).toString()));
        String error = result.getString("error");
        if (!StringUtil.haveNullOrEmpty(error)) {
            throw new IOException(error);
        }
        JSONArray data = result.getJSONArray("data");
        Commodity[] commodities = new Commodity[data.length()];
        for (int i = 0, len = data.length(); i < len; i++) {
            JSONArray t = data.getJSONArray(i);
            commodities[i] = new Commodity(t.getInt(0), t.getInt(1), t.getString(2),
                    (short) t.getInt(3), (float) t.getDouble(4), (float) t.getDouble(5),
                    t.getInt(6), t.getString(7));
        }
        return commodities;
    }

    @Override
    public int deleteCommodityById(int commodityId) throws IOException, JSONException {
        JSONObject result = new JSONObject(HttpUtil.sendHttpPostRequest(url, "delete_commodity_by_id", new JSONObject()
                .put("commodity_id", commodityId).toString()));
        String error = result.getString("error");
        if (!StringUtil.haveNullOrEmpty(error)) {
            throw new IOException(error);
        }
        return result.getInt("affected");
    }

    @Override
    public int updateCommodity(Commodity commodity) throws IOException, JSONException {
        JSONObject result = new JSONObject(HttpUtil.sendHttpPostRequest(url, "update_commodity", new JSONObject()
                .put("commodity_id", commodity.commodityId).put("shop_id", commodity.shopId)
                .put("comm_name", commodity.commName).put("sort", commodity.sort)
                .put("price", commodity.price).put("comm_score", commodity.commScore)
                .put("sales_volume", commodity.salesVolume).put("picture", commodity).toString()));
        String error = result.getString("error");
        if (!StringUtil.haveNullOrEmpty(error)) {
            throw new IOException(error);
        }
        return result.getInt("affected");
    }

    @Override
    public int addCommodity(Commodity commodity) throws IOException, JSONException {
        JSONObject result = new JSONObject(HttpUtil.sendHttpPostRequest(url, "add_commodity", new JSONObject()
                .put("commodity_id", commodity.commodityId).put("shop_id", commodity.shopId)
                .put("comm_name", commodity.commName).put("sort", commodity.sort)
                .put("price", commodity.price).put("comm_score", commodity.commScore)
                .put("sales_volume", commodity.salesVolume).put("picture", commodity).toString()));
        String error = result.getString("error");
        if (!StringUtil.haveNullOrEmpty(error)) {
            throw new IOException(error);
        }
        return result.getInt("affected");
    }
}
