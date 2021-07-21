package com.r948.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.r948.data.model.Address;

@Dao
public interface AddressDao {
    /**
     * 应用场景：用户查询和管理自己的地址
     *
     * @param userId user id
     * @return 用户的所有address
     */
    @Query("select * from address where address.user_id =:userId")
    Address[] findAddressByUserId(int userId);

    /**
     * 应用场景：用户添加一条新的地址
     *
     * @param address address
     */
    @Insert
    void addAddress(Address address);

    /**
     * 应用场景：删除指定的地址
     *
     * @param address address
     */
    @Delete
    void deleteAddressById(Address address);

    /**
     * 应用场景：用户更新自己的某条地址
     *
     * @param address address
     */
    @Update
    void updateAddress(Address address);
}
