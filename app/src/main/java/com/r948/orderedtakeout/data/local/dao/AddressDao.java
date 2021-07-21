package com.r948.orderedtakeout.data.local.dao;

import com.r948.orderedtakeout.data.model.Address;

public interface AddressDao {
    /**
     *
     * 应用场景：用户查询和管理自己的地址
     * @param userId
     * @return 用户的所有address
     * @sql select * from address where address.user_id =: userId;
     */
    Address[] findAddressByUserId(int userId);

    /**
     * 应用场景：用户添加一条新的地址
     * @param address
     * insert into address (user_id,address_name,address_phone,address_lon,address_lat) values(address.userId,address.addressName,address.addressPhone,address.addressLon,address.addressLat);
     */
    void addAddress(Address address);

    /**
     *
     * 应用场景：删除指定的地址
     * @param addressId
     * @sql delete from address where address_id =: addressId;
     */
    void deleteAddressById(int addressId);
    //update by id

    /**
     * 应用场景：用户更新自己的某条地址
     *
     * @param address
     * @param addressId
     * @sql update address set user_id =: userId ,address_name =: address.addressName, address_phone =: address.addressPhone,address_lon =: address.addressLon,address_lat =: addressLat where address_id =: addressId;
     */
    void updateAddress(Address address, int addressId);
}
