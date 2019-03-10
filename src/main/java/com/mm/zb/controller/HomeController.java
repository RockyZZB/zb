package com.mm.zb.controller;

import com.mm.zb.VO.*;
import com.mm.zb.dataObject.Category;
import com.mm.zb.dataObject.ProductInfo;
import com.mm.zb.dataObject.UserProducts;
import com.mm.zb.dataObject.Users;
import com.mm.zb.enums.ResultEnum;
import com.mm.zb.exception.ManagerException;
import com.mm.zb.form.UserForm;
import com.mm.zb.service.CategoryService;
import com.mm.zb.service.ProductInfoService;
import com.mm.zb.service.UserProductsService;
import com.mm.zb.service.impl.UserServiceImpl;
import com.mm.zb.utils.EarnUtils;
import com.mm.zb.utils.KeyUtil;
import com.mm.zb.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Creat by ZB
 * 2019-02-22 22:45
 */
@RestController
@RequestMapping("/user/home")
public class HomeController {


    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private UserProductsService userProductsService;

    @RequestMapping("/list")
    public ResultVO home_list(@CookieValue("userId") String userId) {
        BigDecimal total = new BigDecimal("0.00");
        ManagerVO managerVO = new ManagerVO();
        List<ProductInfoVO> productInfoVOList = new ArrayList<>();
        List<UserProducts> userProductsList = userProductsService
                .findByUserId(userId);
        if (userProductsList != null) {
            for (UserProducts userProducts : userProductsList) {
                ProductInfoVO productInfoVO = new ProductInfoVO();
                productInfoVO.setProductName(userProducts.getProductName());
                productInfoVO.setProductMoney(userProducts.getProductMoney());
                productInfoVO.setYesterdayEarn(EarnUtils.yesterdayEarn(
                        userProducts.getProductMoney()
                ));
                total = total.add(userProducts.getProductMoney());
                productInfoVOList.add(productInfoVO);
            }
        }
        managerVO.setTotalmoney(total);
        managerVO.setYesterdayearn(EarnUtils.yesterdayEarn(total));
        managerVO.setDetail(productInfoVOList);
        return ResultVOUtil.success(managerVO);
    }


    @RequestMapping("/add_list")
    public ResultVO add_list() {
        List<CategoryVO> categoryVOList = new ArrayList<>();
        List<Category> categoryList = categoryService.findAll();
        for (Category category : categoryList) {
            List<ProductInfo> productInfoList = productInfoService
                    .findAllByCategoryType(category.getCategoryType());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                ProductInfoVO productInfoVO = new ProductInfoVO();
                productInfoVO.setProductName(productInfo.getProductName());
                productInfoVOList.add(productInfoVO);
            }
            CategoryVO categoryVO = new CategoryVO();
            categoryVO.setCategoryName(category.getCategoryName());
            categoryVO.setProductInfoVOList(productInfoVOList);
            categoryVOList.add(categoryVO);
        }
        return ResultVOUtil.success(categoryVOList);
    }

    @RequestMapping("/add_product")
    public ResultVO add_product(@CookieValue("userId") String userId, String name, BigDecimal money) {
        Users u = userService.R_get(userId);
        if (u == null) {
            throw new ManagerException(ResultEnum.NO_ENTER);
        }
        UserProducts userProducts = userProductsService.add(userId, name, money);

        return ResultVOUtil.success(userProducts);
    }

    @RequestMapping("/register")
    public ResultVO register(ServletResponse response, @Valid UserForm userForm, BindingResult result) {
        if (result.hasErrors()) {
            throw new ManagerException(11, result.getFieldError().getDefaultMessage());
        }
        Users u = userService.findByUserName(userForm.getUserName());
        if (u != null) {
            throw new ManagerException(12, "用户名已经存在");
        }
        Users NowUser = new Users();
        BeanUtils.copyProperties(userForm, NowUser);
        NowUser.setUserId(KeyUtil.getUniqueKey());
        userService.save(NowUser);
        userService.R_save(NowUser);
        Cookie cookie = new Cookie("userId", NowUser.getUserId());
        cookie.setMaxAge(60);
        ((HttpServletResponse) response).addCookie(cookie);
        return ResultVOUtil.success();
    }

    @RequestMapping("/enter")
    public ResultVO enter(ServletResponse response, @Valid UserForm userForm, BindingResult result) {
        if (result.hasErrors()) {
            throw new ManagerException(11, result.getFieldError().getDefaultMessage());
        }
        Users u = userService.findByUserName(userForm.getUserName());
        if (u == null) {
            throw new ManagerException(14, "用户不存在");
        }
        if (u.getUserPassword().equals(userForm.getUserPassword())) {
            userService.R_save(u);
            Cookie cookie = new Cookie("userId", u.getUserId());
            cookie.setMaxAge(60);
            ((HttpServletResponse) response).addCookie(cookie);
            return ResultVOUtil.success();
        } else {
            throw new ManagerException(13, "密码错误");
        }
    }

}
