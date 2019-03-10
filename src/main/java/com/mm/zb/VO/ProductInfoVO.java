package com.mm.zb.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Creat by ZB
 * 2019-02-22 17:31
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductInfoVO implements Serializable {

    //理财名字
    private String productName;

    //金额
    private BigDecimal productMoney;

    //昨日收益
    private BigDecimal yesterdayEarn;

}
