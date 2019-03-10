package com.mm.zb.service;

import com.mm.zb.dataObject.Category;
import com.mm.zb.dataObject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Creat by ZB
 * 2019-02-22 20:41
 */

public interface ProductInfoService {

    List<ProductInfo> findAll();


    List<ProductInfo> findAllByCategoryType(
            Integer categoryType);
}
