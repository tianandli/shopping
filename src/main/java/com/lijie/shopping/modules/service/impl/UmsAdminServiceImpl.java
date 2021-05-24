package com.lijie.shopping.modules.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lijie.shopping.dto.UmsAdminLoginDto;
import com.lijie.shopping.modules.model.UmsAdmin;
import com.lijie.shopping.modules.mapper.UmsAdminMapper;
import com.lijie.shopping.modules.model.UmsPermission;
import com.lijie.shopping.modules.service.UmsAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lijie.shopping.redis.UmsAdminCacheService;
import com.lijie.shopping.springsecurity.AdminUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author lijie
 * @since 2021-05-13
 */
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements UmsAdminService {


    @Autowired
    private UmsAdminMapper umsAdminMapper;

    @Autowired
    private UmsAdminCacheService umsAdminCacheService;


    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdmin umsAdmin = umsAdminCacheService.getAdmin(username);
        if(umsAdmin == null){
            QueryWrapper<UmsAdmin> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq(true, "username", username);
            List<UmsAdmin> umsAdmins = umsAdminMapper.selectList(queryWrapper);
            if(umsAdmins != null && !umsAdmins.isEmpty()){
                umsAdmin = umsAdmins.get(0);
                umsAdminCacheService.setAdmin(umsAdmin);//插入redis缓存
                return umsAdmin;
            }
        }
        return umsAdmin;
    }
}
