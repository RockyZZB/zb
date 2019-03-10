package com.mm.zb.repository;

import com.mm.zb.dataObject.UserProducts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Creat by ZB
 * 2019-02-22 23:50
 */
public interface UserProductsRepository extends JpaRepository<UserProducts, String> {

    List<UserProducts> findByUserId(String userId);

    void deleteByThisId(String thisId);
}
