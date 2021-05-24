package com.lijie.shopping.modules.service;

import com.lijie.shopping.dto.UmsAdminLoginDto;
import com.lijie.shopping.modules.model.UmsAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lijie.shopping.modules.model.UmsPermission;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author lijie
 * @since 2021-05-13
 */
public interface UmsAdminService extends IService<UmsAdmin> {

    /**
     * 描述：根据username查一个管理员。先查缓存，缓存没有查数据库
     * @param username
     * @return org.springframework.security.core.userdetails.UserDetails
     * @author lijie
     * @date 2021/5/13 15:41
     */
    UmsAdmin getAdminByUsername(String username);
}
