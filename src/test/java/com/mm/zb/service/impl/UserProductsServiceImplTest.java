package com.mm.zb.service.impl;

import com.mm.zb.dataObject.UserProducts;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Creat by ZB
 * 2019-02-22 23:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserProductsServiceImplTest {

    @Autowired
    private UserProductsServiceImpl userProductsService;

    @Test
    public void findByUserProductsID() {

        List<UserProducts> li = userProductsService.findByUserId("1");
        System.out.println(li);

    }

    @Test
    public void save() {
        userProductsService.add("1", "小赢理财", new BigDecimal(10000.00));


    }

}