package com.mm.zb.service.impl;

import com.mm.zb.dataObject.ProductInfo;
import com.mm.zb.utils.KeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Creat by ZB
 * 2019-02-23 15:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Test
    public void findAll() {
        List<ProductInfo> all = productInfoService.findAll();
        System.out.println(all);
    }

    @Test
    public void findAllByCategoryType() {
        List<ProductInfo> all = productInfoService.findAllByCategoryType(1);
        System.out.println(all);
    }
}