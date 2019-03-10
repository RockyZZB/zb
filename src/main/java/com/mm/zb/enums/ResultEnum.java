package com.mm.zb.enums;


import lombok.Getter;

/**
 * Creat by ZB
 * 2019-02-22 18:02
 */
@Getter
public enum ResultEnum {


    NOTHING(1, "什么都没有"),
    NO_ENTER(15, "请先登入");
    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
