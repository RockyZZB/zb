package com.mm.zb.service.impl;

import com.mm.zb.dataObject.Category;
import com.mm.zb.repository.CategoryRepository;
import com.mm.zb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Creat by ZB
 * 2019-02-23 15:14
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {

        List<Category> list = categoryRepository.findAll();

        return list;
    }
}
