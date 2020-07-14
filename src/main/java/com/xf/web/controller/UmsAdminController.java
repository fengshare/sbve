package com.xf.web.controller;


import com.xf.web.common.result.CommonResult;
import com.xf.web.dto.UmsAdminParam;
import com.xf.web.entity.UmsAdmin;
import com.xf.web.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author xf
 * @since 2020-07-13
 */
@RestController
@RequestMapping("/ums-admin")
public class UmsAdminController {

    @Autowired
    private UmsAdminService umsAdminService;

    @RequestMapping("/register")
    public CommonResult register(@RequestBody UmsAdminParam umsAdminParam) {
        UmsAdmin umsAdmin = umsAdminService.register(umsAdminParam);
        if (umsAdmin == null) {
            return CommonResult.failed();
        }
        return CommonResult.success("注册成功");
    }




}
