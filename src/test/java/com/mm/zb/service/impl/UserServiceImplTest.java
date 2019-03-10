package com.mm.zb.service.impl;

import com.mm.zb.dataObject.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Creat by ZB
 * 2019-02-23 20:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void findByUserName() {
        Users zz = userService.findByUserName("郑波");
        System.out.println(zz);
    }

    @Test
    public void R_save() {
        Users users = new Users();
        users.setUserId("1");
        users.setUserName("z");
        users.setUserPassword("2");
        userService.R_save(users);

    }

    @Test
    public void R_get() {
        String id = "1";
        Users users = userService.R_get(id);

    }
}