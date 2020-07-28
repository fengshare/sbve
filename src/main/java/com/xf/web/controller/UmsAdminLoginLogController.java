package com.xf.web.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 后台用户登录日志表 前端控制器
 * </p>
 *
 * @author xf
 * @since 2020-07-15
 */
@RestController
@RequestMapping("/ums-admin-log")
public class UmsAdminLoginLogController {

    @RequestMapping("/test")
    public String test(){
        return "abc";
    }

}
