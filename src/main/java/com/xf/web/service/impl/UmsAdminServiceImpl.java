package com.xf.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xf.web.common.enums.DbStatus;
import com.xf.web.dto.UmsAdminParam;
import com.xf.web.entity.UmsAdmin;
import com.xf.web.mapper.UmsAdminLoginLogMapper;
import com.xf.web.mapper.UmsAdminMapper;
import com.xf.web.service.UmsAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author xf
 * @since 2020-07-13
 */
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements UmsAdminService {

    @Autowired
    private UmsAdminMapper umsAdminMapper;


    @Autowired
    private UmsAdminLoginLogMapper umsAdminLoginLogMapper;

    @Override
    public UmsAdmin register(UmsAdminParam umsAdminParam) {
        Integer count = umsAdminMapper.selectCount(new QueryWrapper<UmsAdmin>().lambda()
                .eq(UmsAdmin::getUsername, umsAdminParam.getUserName())
                .eq(UmsAdmin::getStatus, DbStatus.Y.getValue())
        );
        if (count > 0) {
            return null;
        }
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdminMapper.insert(umsAdmin);
        return umsAdmin;
    }

    @Override
    public String login(String username, String password) {

        return null;
    }



}
