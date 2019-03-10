package com.mm.zb.service;

import com.mm.zb.dataObject.Users;

/**
 * Creat by ZB
 * 2019-02-23 20:52
 */
public interface UserService {

    Users findByUserName(String userName);

    void R_save(Users users);

    void save(Users users);

    Users R_get(String userId);
}
