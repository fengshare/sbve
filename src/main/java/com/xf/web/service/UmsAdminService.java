package com.xf.web.service;

import com.xf.web.dto.UmsAdminParam;
import com.xf.web.entity.UmsAdmin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author xf
 * @since 2020-07-13
 */
public interface UmsAdminService extends IService<UmsAdmin> {

    UmsAdmin register(UmsAdminParam umsAdminParam);

    String login(String username, String password);
}
