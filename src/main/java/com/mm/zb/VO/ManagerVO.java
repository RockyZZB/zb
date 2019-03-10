package com.mm.zb.VO;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Creat by ZB
 * 2019-02-22 23:46
 */
@Data

public class ManagerVO implements Serializable {

    private BigDecimal totalmoney;

    private BigDecimal yesterdayearn;

    private List<ProductInfoVO> detail;
}
