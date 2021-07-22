package com.r948.data.net.dao.django;

import com.r948.data.model.Address;
import com.r948.data.net.dao.AddressDao;
import com.r948.utilities.HttpUtil;
import com.r948.utilities.StringUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class DjangoAddressDao implements AddressDao {

    private final String url;

    public DjangoAddressDao(String url) {
        this.url = url;
    }

    @Override
    public Address[] findAddressByUserId(int userId) throws IOException, JSONException {
        JSONObject result = new JSONObject(HttpUtil.sendHttpPostRequest(url, "find_address_by_user_id",
                new JSONObject()
                        .put("user_id", userId).toString()));
        String error = result.getString("error");
        if (!StringUtil.haveNullOrEmpty(error)) {
            throw new IOException(error);
        }
        JSONArray data = result.getJSONArray("data");
        Address[] addresses = new Address[data.length()];
        for (int i = 0, len = data.length(); i < len; i++) {
            JSONArray t = data.getJSONArray(i);
            addresses[i] = new Address(t.getInt(0), t.getInt(1), t.getString(2)
                    , t.getString(3), t.getDouble(4), t.getDouble(5));
        }
        return addresses;
    }

    @Override
    public int addAddress(Address address) throws IOException, JSONException {
        JSONObject result = new JSONObject(HttpUtil.sendHttpPostRequest(url, "add_address", new JSONObject()
                .put("address_id", address.addressId).put("user_id", address.userId)
                .put("address_name", address.addressName).put("address_phone", address.addressPhone)
                .put("address_lon", address.addressLon).put("address_lat", address.addressLat).toString()));
        String error = result.getString("error");
        if (!StringUtil.haveNullOrEmpty(error)) {
            throw new IOException(error);
        }
        return result.getInt("affected");
    }

    @Override
    public int deleteAddressById(int addressId) throws IOException, JSONException {
        JSONObject result = new JSONObject(HttpUtil.sendHttpPostRequest(url, "delete_address_by_id", new JSONObject()
                .put("address_id", addressId).toString()));
        String error = result.getString("error");
        if (!StringUtil.haveNullOrEmpty(error)) {
            throw new IOException(error);
        }
        return result.getInt("affected");
    }

    @Override
    public int updateAddress(Address address) throws IOException, JSONException {
        JSONObject result = new JSONObject(HttpUtil.sendHttpPostRequest(url, "update_address", new JSONObject()
                .put("address_id", address.addressId).put("user_id", address.userId)
                .put("address_name", address.addressName).put("address_phone", address.addressPhone)
                .put("address_lon", address.addressLon).put("address_lat", address.addressLat).toString()));
        String error = result.getString("error");
        if (!StringUtil.haveNullOrEmpty(error)) {
            throw new IOException(error);
        }
        return result.getInt("affected");
    }
}
