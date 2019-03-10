package com.mm.zb.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * Creat by ZB
 * 2019-02-22 17:27
 */
@Data
public class ResultVO<T> implements Serializable {

    //错误码
    private Integer code;

    //错误信息
    private String msg;

    //返回内容
    private T data;

}
