package com.lijie.shopping.modules.service;

import com.lijie.shopping.modules.model.UmsMember;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author lijie
 * @since 2021-05-13
 */
public interface UmsMemberService extends IService<UmsMember> {

    /**
     * 描述：根据手机号获取验证码
     * @param telephone 手机号
     * @return java.lang.String
     * @author lijie
     * @date 2021/5/13 10:55
     */
    public String getAuthCode(String telephone);
}
