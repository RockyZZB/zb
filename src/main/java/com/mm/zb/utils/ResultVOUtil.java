package com.mm.zb.utils;

import com.mm.zb.VO.ResultVO;

/**
 * Creat by ZB
 * 2019-02-22 17:57
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success() {

        return success(null);
    }

    ;

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        resultVO.setData(" ");
        return resultVO;
    }
}
