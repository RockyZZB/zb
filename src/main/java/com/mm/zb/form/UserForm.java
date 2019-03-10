package com.mm.zb.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Creat by ZB
 * 2019-02-23 0:11
 */
@Data
public class UserForm implements Serializable {

    @NotBlank(message = "用户名不能为空")
    @Size(max = 8, min = 5, message = "用户名长度为5到8位")
    private String userName;


    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 11, message = "密码长度为8到11位")
    private String userPassword;

}
