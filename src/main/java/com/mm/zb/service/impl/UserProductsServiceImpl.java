package com.mm.zb.service.impl;

import com.mm.zb.dataObject.ProductInfo;
import com.mm.zb.dataObject.UserProducts;
import com.mm.zb.repository.ProductRepository;
import com.mm.zb.repository.UserProductsRepository;
import com.mm.zb.service.UserProductsService;
import com.mm.zb.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

/**
 * Creat by ZB
 * 2019-02-22 23:55
 */
@Service
public class UserProductsServiceImpl implements UserProductsService {

    @Autowired
    private UserProductsRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<UserProducts> findByUserId(String userId) {

        List<UserProducts> list = repository
                .findByUserId(userId);
        return list;
    }

    @Override
    @Transactional
    public UserProducts add(String userId, String userProductName, BigDecimal productMoney) {
        List<UserProducts> userProductsList = repository.findByUserId(userId);
        int t = 0;
        if (userProductsList != null) {
            for (UserProducts userProducts : userProductsList) {
                if (userProducts.getProductName().equals(userProductName)) {
                    String thisId = userProducts.getThisId();
                    BigDecimal old = userProducts.getProductMoney();
                    BigDecimal now = old.add(productMoney);
                    UserProducts nowproducts = new UserProducts();
                    BeanUtils.copyProperties(userProducts, nowproducts);
                    nowproducts.setProductMoney(now);
                    nowproducts.setThisId(KeyUtil.getUniqueKey());
                    repository.save(nowproducts);
                    repository.deleteByThisId(thisId);
                    t++;
                }
            }
        }
        if (t == 0) {
            ProductInfo productInfo = productRepository.findByProductName(userProductName);
            UserProducts userProducts = new UserProducts();
            BeanUtils.copyProperties(productInfo, userProducts);
            userProducts.setProductMoney(productMoney);
            userProducts.setUserId(userId);
            userProducts.setThisId(KeyUtil.getUniqueKey());
            repository.save(userProducts);
        }
        return null;
    }
}
