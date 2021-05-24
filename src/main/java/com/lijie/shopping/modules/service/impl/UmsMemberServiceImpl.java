package com.lijie.shopping.modules.service.impl;

import com.lijie.shopping.modules.model.UmsMember;
import com.lijie.shopping.modules.mapper.UmsMemberMapper;
import com.lijie.shopping.modules.service.UmsMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lijie.shopping.redis.UmsMemberCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author lijie
 * @since 2021-05-13
 */
@Service
public class UmsMemberServiceImpl extends ServiceImpl<UmsMemberMapper, UmsMember> implements UmsMemberService {

    @Autowired
    private UmsMemberCacheService umsMemberCacheService;

    @Override
    public String getAuthCode(String telephone) {
        String code = String.valueOf((int)((Math.random()*9+1)*100000));//生成6位的随机数
        umsMemberCacheService.setAuthCode(telephone, code);//将验证码加入到redis
        return code;
    }
}
