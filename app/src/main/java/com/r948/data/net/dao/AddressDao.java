package com.r948.data.net.dao;

import com.r948.data.model.Address;

import org.json.JSONException;

import java.io.IOException;

public interface AddressDao {
    /**
     * 应用场景：用户查询和管理自己的地址
     *
     * @param userId user id
     * @return 用户的所有address
     * @sql select * from address where user_id =: userId;
     */
    Address[] findAddressByUserId(int userId) throws IOException, JSONException;

    /**
     * 应用场景：用户添加一条新的地址
     *
     * @param address
     */
    int addAddress(Address address) throws IOException, JSONException;

    /**
     * 应用场景：删除指定的地址
     *
     * @param addressId
     */
    int deleteAddressById(int addressId) throws IOException, JSONException;

    /**
     * 应用场景：用户更新自己的某条地址
     *
     * @param address
     * @sql update address set user_id =: userId ,address_name =: address.addressName, address_phone =: address.addressPhone,
     * address_lon =: address.addressLon,address_lat =: addressLat where address_id =: address.addressId;
     */
    int updateAddress(Address address) throws IOException, JSONException;
}
