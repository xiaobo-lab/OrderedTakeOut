package com.r948.data.net.dao;

import com.r948.data.model.Deliver;

import org.json.JSONException;

import java.io.IOException;

public interface DeliverDao {
    /**
     * 派送员管理自己的相关信息
     * @param userId
     * @return 派送员相关信息（一个）
     * @sql select * from deliver where user_id =:userId;
     */
    Deliver[] findDeliverByUserId(int userId)throws IOException, JSONException;

    /**
     * 查看订单的派送员
     * @param deliverId
     * @return 派送员相关信息（一个）
     * @sql select * from deliver where deliver_id =:deliverId;
     */
    Deliver[] findDeliverByDeliverId(int deliverId)throws IOException, JSONException;
}
