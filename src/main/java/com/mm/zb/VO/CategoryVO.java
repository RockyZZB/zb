package com.mm.zb.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mm.zb.dataObject.Category;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Creat by ZB
 * 2019-02-23 15:05
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryVO implements Serializable {

    private String CategoryName;

    private List<ProductInfoVO> productInfoVOList;

}
