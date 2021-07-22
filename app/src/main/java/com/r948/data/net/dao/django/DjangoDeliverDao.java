package com.r948.data.net.dao.django;

import com.r948.data.model.Deliver;
import com.r948.data.net.dao.DeliverDao;
import com.r948.utilities.HttpUtil;
import com.r948.utilities.StringUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class DjangoDeliverDao implements DeliverDao {

    private final String url;

    public DjangoDeliverDao(String url) {
        this.url = url;
    }

    @Override
    public Deliver[] findDeliverByUserId(int userId) throws IOException, JSONException {
        JSONObject result = new JSONObject(HttpUtil.sendHttpPostRequest(url, "find_deliver_by_user_id", new JSONObject()
                .put("user_id", userId).toString()));
        String error = result.getString("error");
        if (!StringUtil.haveNullOrEmpty(error)) {
            throw new IOException(error);
        }
        JSONArray data = result.getJSONArray("data");
        Deliver[] delivers = new Deliver[data.length()];
        for (int i = 0, len = data.length(); i < len; i++) {
            JSONArray t = data.getJSONArray(i);
            delivers[i] = new Deliver(t.getInt(0), t.getInt(1), (float) t.getDouble(2), t.getInt(3));
        }
        return delivers;
    }

    @Override
    public Deliver[] findDeliverByDeliverId(int deliverId) throws IOException, JSONException {
        JSONObject result = new JSONObject(HttpUtil.sendHttpPostRequest(url, "find_deliver_by_deliver_id", new JSONObject()
                .put("deliver_id", deliverId).toString()));
        String error = result.getString("error");
        if (!StringUtil.haveNullOrEmpty(error)) {
            throw new IOException(error);
        }
        JSONArray data = result.getJSONArray("data");
        Deliver[] delivers = new Deliver[data.length()];
        for (int i = 0, len = data.length(); i < len; i++) {
            JSONArray t = data.getJSONArray(i);
            delivers[i] = new Deliver(t.getInt(0), t.getInt(1), (float) t.getDouble(2), t.getInt(3));
        }
        return delivers;
    }
}
