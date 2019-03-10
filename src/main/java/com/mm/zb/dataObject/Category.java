package com.mm.zb.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Creat by ZB
 * 2019-02-22 18:16
 */
@Data
@Entity
public class Category implements Serializable {

    @Id
    private Integer categoryType;

    private String categoryName;


}
