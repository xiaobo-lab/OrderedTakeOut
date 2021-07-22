package com.r948.data.net.dao.django;

import com.r948.data.model.Shop;
import com.r948.data.net.dao.ShopDao;
import com.r948.utilities.HttpUtil;
import com.r948.utilities.StringUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class DjangoShopDao implements ShopDao {

    private final String url;

    public DjangoShopDao(String url) {
        this.url = url;
    }

    @Override
    public Shop[] findShopByUserId(int userId) throws IOException, JSONException {
        JSONObject result = new JSONObject(HttpUtil.sendHttpPostRequest(url, "find_shop_by_user_id", new JSONObject()
                .put("user_id", userId).toString()));
        String error = result.getString("error");
        if (!StringUtil.haveNullOrEmpty(error)) {
            throw new IOException(error);
        }
        JSONArray data = result.getJSONArray("data");
        Shop[] shops = new Shop[data.length()];
        for (int i = 0, len = data.length(); i < len; i++) {
            JSONArray t = data.getJSONArray(i);
            shops[i] = new Shop(t.getInt(0), t.getInt(1), t.getString(2),
                    t.getDouble(3), t.getDouble(4), t.getString(5),
                    t.getInt(6), (byte) t.getInt(7), t.getString(8));
        }
        return shops;
    }

    @Override
    public Shop[] findShopByShopId(int shopId) throws IOException, JSONException {
        JSONObject result = new JSONObject(HttpUtil.sendHttpPostRequest(url, "find_shop_by_shop_id", new JSONObject()
                .put("shop_id", shopId).toString()));
        String error = result.getString("error");
        if (!StringUtil.haveNullOrEmpty(error)) {
            throw new IOException(error);
        }
        JSONArray data = result.getJSONArray("data");
        Shop[] shops = new Shop[data.length()];
        for (int i = 0, len = data.length(); i < len; i++) {
            JSONArray t = data.getJSONArray(i);
            shops[i] = new Shop(t.getInt(0), t.getInt(1), t.getString(2),
                    t.getDouble(3), t.getDouble(4), t.getString(5),
                    t.getInt(6), (byte) t.getInt(7), t.getString(8));
        }
        return shops;
    }

    @Override
    public Shop[] findShopByCommSort(int sort) throws IOException, JSONException {
        JSONObject result = new JSONObject(HttpUtil.sendHttpPostRequest(url, "find_shop_by_comm_sort", new JSONObject()
                .put("sort", sort).toString()));
        String error = result.getString("error");
        if (!StringUtil.haveNullOrEmpty(error)) {
            throw new IOException(error);
        }
        JSONArray data = result.getJSONArray("data");
        Shop[] shops = new Shop[data.length()];
        for (int i = 0, len = data.length(); i < len; i++) {
            JSONArray t = data.getJSONArray(i);
            shops[i] = new Shop(t.getInt(0), t.getInt(1), t.getString(2),
                    t.getDouble(3), t.getDouble(4), t.getString(5),
                    t.getInt(6), (byte) t.getInt(7), t.getString(8));
        }
        return shops;
    }

    @Override
    public int addShop(Shop shop) throws IOException, JSONException {
        JSONObject result = new JSONObject(HttpUtil.sendHttpPostRequest(url, "add_shop", new JSONObject()
                .put("shop_id", shop.shopId).put("user_id", shop.userId).put("shop_nme", shop.shopName)
                .put("shop_lon", shop.shopLon).put("shop_lat", shop.shopLat)
                .put("introduction", shop.introduction).put("distance", shop.distance)
                .put("state", shop.state).put("shop_head_icon", shop.shopHeadIcon).toString()));
        String error = result.getString("error");
        if (!StringUtil.haveNullOrEmpty(error)) {
            throw new IOException(error);
        }
        return result.getInt("affected");
    }

    @Override
    public int updateShop(Shop shop) throws IOException, JSONException {
        JSONObject result = new JSONObject(HttpUtil.sendHttpPostRequest(url, "update_shop", new JSONObject()
                .put("shop_id", shop.shopId).put("user_id", shop.userId).put("shop_nme", shop.shopName)
                .put("shop_lon", shop.shopLon).put("shop_lat", shop.shopLat)
                .put("introduction", shop.introduction).put("distance", shop.distance)
                .put("state", shop.state).put("shop_head_icon", shop.shopHeadIcon).toString()));
        String error = result.getString("error");
        if (!StringUtil.haveNullOrEmpty(error)) {
            throw new IOException(error);
        }
        return result.getInt("affected");
    }
}
