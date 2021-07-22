package com.r948.data.net.dao.django;

import com.r948.data.model.User;
import com.r948.data.net.dao.UserDao;
import com.r948.utilities.HttpUtil;
import com.r948.utilities.StringUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class DjangoUserDao implements UserDao {
    private final String url;

    public DjangoUserDao(String url) {
        this.url = url;
    }

    @Override
    public User[] findUserByPhone(String userPhone) throws JSONException, IOException {
        JSONObject result = new JSONObject(HttpUtil.sendHttpPostRequest(url, new JSONObject().put("user_phone", userPhone).toString()));
        String error = result.getString("error");
        if (!StringUtil.haveNullOrEmpty(error)) {
            throw new IOException(error);
        }
        JSONArray data = result.getJSONArray("data");
        User[] users = new User[data.length()];
        for (int i = 0, l = data.length(); i < l; i++) {
            JSONArray t = data.getJSONArray(i);
            users[i] = new User(t.getInt(0), t.getString(1), t.getString(2), t.getString(3), (byte) t.getInt(4), t.getString(5));
        }
        return users;
    }

    @Override
    public User[] queryUsersByLoginInfo(String phone, String password) {
        return new User[0];
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }
}
