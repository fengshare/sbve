package com.xf.web.service.impl;

import com.xf.web.common.constants.RedisConstants;
import com.xf.web.common.redisUtils.RedisUtil;
import com.xf.web.entity.UmsAdmin;
import com.xf.web.entity.UmsResource;
import com.xf.web.service.AdminCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xf
 */
@Service
public class AdminCacheServiceImpl implements AdminCacheService {

    @Autowired
    private RedisUtil redisUtil;

    @Value("${redis.database}")
    private String REDIS_DATABASE;

    @Override
    public UmsAdmin getAdmin(String username) {
        String key = REDIS_DATABASE + ":" + RedisConstants.REDIS_KEY_ADMIN + ":" + username;
        return (UmsAdmin) redisUtil.get(key);
    }

    @Override
    public void setAdmin(UmsAdmin admin) {
        String key = REDIS_DATABASE + ":" + RedisConstants.REDIS_KEY_ADMIN + ":" + admin.getUsername();
        redisUtil.set(key, admin);
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId) {


        return null;
    }

    @Override
    public void setResourceList(Long adminId, List<UmsResource> resourceList) {

    }
}
