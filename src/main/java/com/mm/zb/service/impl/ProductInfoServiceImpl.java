package com.mm.zb.service.impl;

import com.mm.zb.dataObject.Category;
import com.mm.zb.dataObject.ProductInfo;
import com.mm.zb.repository.CategoryRepository;
import com.mm.zb.repository.ProductRepository;
import com.mm.zb.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Creat by ZB
 * 2019-02-22 21:23
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<ProductInfo> findAll() {

        List<ProductInfo> list = repository.findAll();


        return list;
    }


    @Override
    public List<ProductInfo> findAllByCategoryType(Integer categoryType) {
        Pageable pageable1 = new PageRequest(0, 5);
        Page<ProductInfo> all = repository
                .findAllByCategoryType(categoryType, pageable1);
        List<ProductInfo> list = all.getContent();
        return list;
    }
}
