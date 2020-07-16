package com.xf.web.service;

import com.xf.web.dto.UmsAdminParam;
import com.xf.web.entity.UmsAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xf.web.entity.UmsResource;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

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

    /**
     * 根据用户名获取后台管理员
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);

    List<UmsResource> getResourceList(Long adminId);
}
