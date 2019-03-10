package com.mm.zb.utils;

import java.util.Random;

/**
 * Creat by ZB
 * 2019-02-23 16:25
 */
public class KeyUtil {
    public static synchronized String getUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(10000) + 10000;
        return System.currentTimeMillis() + String.valueOf(number);
    }

}
