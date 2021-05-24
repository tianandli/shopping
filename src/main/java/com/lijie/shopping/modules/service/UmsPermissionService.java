package com.lijie.shopping.modules.service;

import com.lijie.shopping.modules.model.UmsPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 后台用户权限表 服务类
 * </p>
 *
 * @author lijie
 * @since 2021-05-13
 */
public interface UmsPermissionService extends IService<UmsPermission> {
    /**
     * 描述：根据管理员的id去查这个管理员所有的权限
     *
     * @param adminId 管理员的id
     * @return java.util.List<com.lijie.shopping.modules.model.UmsPermission>
     * @author lijie
     * @date 2021/5/13 15:16
     */
    List<UmsPermission> getPermissionsByAdminId(Long adminId);
}
