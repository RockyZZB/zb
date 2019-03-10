package com.mm.zb.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Creat by ZB
 * 2019-02-22 18:19
 */
@Entity
@Data
public class ProductInfo implements Serializable {

    @Id
    private String productId;

    private String productName;

    private Integer categoryType;

}
