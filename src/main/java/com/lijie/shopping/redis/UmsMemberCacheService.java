package com.lijie.shopping.redis;

import com.lijie.shopping.modules.model.UmsMember;

/**
 * 功能描述：会员缓存到redis
 *
 * @author: lijie
 * @date: 2021/5/13 10:45
 * @version: V1.0
 */
public interface UmsMemberCacheService {
    /**
     * 删除会员用户缓存
     */
    void delMember(Long memberId);

    /**
     * 获取会员用户缓存
     */
    UmsMember getMember(String username);

    /**
     * 设置会员用户缓存
     */
    void setMember(UmsMember member);

    /**
     * 设置验证码
     */
    void setAuthCode(String telephone, String authCode);

    /**
     * 获取验证码
     */
    String getAuthCode(String telephone);
}
