package com.mm.zb.service;

import com.mm.zb.dataObject.UserProducts;

import java.math.BigDecimal;
import java.util.List;

/**
 * Creat by ZB
 * 2019-02-22 23:54
 */
public interface UserProductsService {

    List<UserProducts> findByUserId(String userId);

    UserProducts add(String userId, String userProductName, BigDecimal productMoney);

}
