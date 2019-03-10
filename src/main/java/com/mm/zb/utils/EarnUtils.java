package com.mm.zb.utils;

import java.math.BigDecimal;

/**
 * Creat by ZB
 * 2019-02-23 0:48
 */
public class EarnUtils {
    public static BigDecimal yesterdayEarn(BigDecimal b) {
        BigDecimal a = new BigDecimal(3650.00);
        BigDecimal c = b.divide(a, 2);

        return c;
    }
}
