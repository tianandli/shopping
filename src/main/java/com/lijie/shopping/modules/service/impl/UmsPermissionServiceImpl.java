package com.lijie.shopping.modules.service.impl;

import com.lijie.shopping.modules.mapper.UmsAdminMapper;
import com.lijie.shopping.modules.model.UmsPermission;
import com.lijie.shopping.modules.mapper.UmsPermissionMapper;
import com.lijie.shopping.modules.service.UmsPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 后台用户权限表 服务实现类
 * </p>
 *
 * @author lijie
 * @since 2021-05-13
 */
@Service
public class UmsPermissionServiceImpl extends ServiceImpl<UmsPermissionMapper, UmsPermission> implements UmsPermissionService {

    @Autowired
    private UmsPermissionMapper umsPermissionMapper;

    @Override
    public List<UmsPermission> getPermissionsByAdminId(Long adminId) {
        return umsPermissionMapper.getPermissionsByAdminId(adminId);
    }
}
