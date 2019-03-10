package com.mm.zb.exception;

import com.mm.zb.enums.ResultEnum;

/**
 * Creat by ZB
 * 2019-02-22 18:01
 */
public class ManagerException extends RuntimeException {

    private Integer code;

    public ManagerException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public ManagerException(ResultEnum resuleEnum) {
        super(resuleEnum.getMsg());
        this.code = resuleEnum.getCode();


    }

}
