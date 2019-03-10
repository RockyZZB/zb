package com.mm.zb.repository;

import com.mm.zb.dataObject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Creat by ZB
 * 2019-02-22 20:39
 */
public interface ProductRepository extends JpaRepository<ProductInfo, String> {

    Page<ProductInfo> findAllByCategoryType(
            Integer categoryType, Pageable pageable);

    ProductInfo findByProductName(String productName);

}
