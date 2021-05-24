package com.lijie.shopping.modules.mapper;

import com.lijie.shopping.modules.model.UmsPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 后台用户权限表 Mapper 接口
 * </p>
 *
 * @author lijie
 * @since 2021-05-13
 */
public interface UmsPermissionMapper extends BaseMapper<UmsPermission> {
    public List<UmsPermission> getPermissionsByAdminId(Long adminId);
}
