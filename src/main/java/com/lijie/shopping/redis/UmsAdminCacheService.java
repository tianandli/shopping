package com.lijie.shopping.redis;

import com.lijie.shopping.modules.model.UmsAdmin;

/**
 * 后台用户缓存操作类
 * Created by macro on 2020/3/13.
 */
public interface UmsAdminCacheService {

    /**
     * 获取缓存后台用户信息
     */
    UmsAdmin getAdmin(String username);

    /**
     * 设置缓存后台用户信息
     */
    void setAdmin(UmsAdmin admin);
}
