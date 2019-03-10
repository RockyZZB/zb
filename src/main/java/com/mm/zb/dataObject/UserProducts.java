package com.mm.zb.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Creat by ZB
 * 2019-02-22 18:23
 */
@Entity
@Data
public class UserProducts implements Serializable {

    @Id
    private String thisId;

    private String userId;

    private String productId;

    private String productName;

    private BigDecimal productMoney;

    private Integer categoryType;

}
