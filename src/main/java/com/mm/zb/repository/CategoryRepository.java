package com.mm.zb.repository;

import com.mm.zb.dataObject.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Creat by ZB
 * 2019-02-22 20:34
 */
public interface CategoryRepository extends JpaRepository<Category, String> {

}
