package com.xf.web.service;

import com.xf.web.entity.UmsAdmin;
import com.xf.web.entity.UmsResource;

import java.util.List;

/**
 * @author Administrator
 */
public interface AdminCacheService {

    UmsAdmin getAdmin(String username);

    void setAdmin(UmsAdmin admin);

    List<UmsResource> getResourceList(Long adminId);

    void setResourceList(Long adminId, List<UmsResource> resourceList);
}
