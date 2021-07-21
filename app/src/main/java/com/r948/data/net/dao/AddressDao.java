package com.r948.data.net.dao;

import com.r948.data.model.Address;

import java.io.IOException;

public interface AddressDao {
    /**
     * 应用场景：用户查询和管理自己的地址
     *
     * @param userId
     * @return 用户的所有address
     * @sql select * from address where address.user_id =: userId;
     */
    Address[] findAddressByUserId(int userId) throws IOException;

    /**
     * 应用场景：用户添加一条新的地址
     *
     * @param address insert into address (user_id,address_name,address_phone,address_lon,address_lat) values(address.userId,address.addressName,address.addressPhone,address.addressLon,address.addressLat);
     */
    int addAddress(Address address) throws IOException;

    /**
     * 应用场景：删除指定的地址
     *
     * @param addressId
     * @sql delete from address where address_id =: addressId;
     */
    int deleteAddressById(int addressId) throws IOException;

    /**
     * 应用场景：用户更新自己的某条地址
     *
     * @param address
     * @param addressId
     * @sql update address set user_id =: userId ,address_name =: address.addressName, address_phone =: address.addressPhone,address_lon =: address.addressLon,address_lat =: addressLat where address_id =: addressId;
     */
    int updateAddress(Address address, int addressId) throws IOException;
}
