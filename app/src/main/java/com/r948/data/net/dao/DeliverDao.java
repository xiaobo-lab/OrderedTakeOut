package com.r948.data.net.dao;

import com.r948.data.model.Deliver;

public interface DeliverDao {
    /**
     * 派送员管理自己的相关信息
     * @param deliverId
     * @return 派送员相关信息（一个）
     * @sql select * from deliver where deliver_id =:deliverId;
     */
    Deliver[] findDeliverByUserId(int deliverId);
}
