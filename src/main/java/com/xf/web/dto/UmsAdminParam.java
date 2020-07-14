package com.xf.web.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author Administrator
 */
@Data
public class UmsAdminParam {
    @NotEmpty(message = "用户名不能为空")
    private String userName;

    @NotEmpty(message = "密码不能为空")
    private String password;

    private String icon;

    private String email;

    private String nickName;

    private String note;
}
