package com.mm.zb.repository;

import com.mm.zb.dataObject.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Creat by ZB
 * 2019-02-23 20:50
 */
public interface UserRepository extends JpaRepository<Users, String> {
    Users findByUserName(String userName);

}
