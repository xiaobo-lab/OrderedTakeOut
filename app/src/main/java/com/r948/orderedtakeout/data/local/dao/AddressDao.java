package com.r948.orderedtakeout.data.local.dao;

import com.r948.orderedtakeout.data.model.Address;

public interface AddressDao {
    //select * from address where address.user_id =: userId;
    Address[] findAddressByUserId(Integer userId);
    //add
    void addAddress(Address address);
    //delete by id
    void deleteAddressById(Integer id);
}
