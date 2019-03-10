package com.mm.zb.dataObject;

import lombok.Data;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Creat by ZB
 * 2019-02-22 18:21
 */
@Entity
@Data
public class Users implements Serializable {


    private String userId;

    @Id
    private String userName;

    private String userPassword;


}
