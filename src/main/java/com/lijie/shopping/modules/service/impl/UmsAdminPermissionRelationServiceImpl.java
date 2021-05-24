package com.lijie.shopping.modules.service.impl;

import com.lijie.shopping.modules.model.UmsAdminPermissionRelation;
import com.lijie.shopping.modules.mapper.UmsAdminPermissionRelationMapper;
import com.lijie.shopping.modules.service.UmsAdminPermissionRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限) 服务实现类
 * </p>
 *
 * @author lijie
 * @since 2021-05-13
 */
@Service
public class UmsAdminPermissionRelationServiceImpl extends ServiceImpl<UmsAdminPermissionRelationMapper, UmsAdminPermissionRelation> implements UmsAdminPermissionRelationService {

}
