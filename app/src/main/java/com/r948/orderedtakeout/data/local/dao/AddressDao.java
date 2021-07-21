package com.r948.orderedtakeout.data.local.dao;

import com.r948.orderedtakeout.data.model.Address;

public interface AddressDao {
    //select * from address ,user_address where address.user_id =: userId and user_address.address_id = address.address_id
    Address[] findAddressByUserId(Integer userId);
}
