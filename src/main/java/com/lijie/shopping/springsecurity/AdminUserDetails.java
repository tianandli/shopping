package com.lijie.shopping.springsecurity;

import com.lijie.shopping.modules.model.UmsAdmin;
import com.lijie.shopping.modules.model.UmsPermission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 功能描述：SpringSecurity需要的用户详情
 *
 * @author: lijie
 * @date: 2021/5/13 14:23
 * @version: V1.0
 */
@Slf4j
public class AdminUserDetails implements UserDetails {
    private UmsAdmin umsAdmin;
    private List<UmsPermission> umsPermissionList;

    public AdminUserDetails(UmsAdmin umsAdmin, List<UmsPermission> umsPermissionList) {
        this.umsAdmin = umsAdmin;
        this.umsPermissionList = umsPermissionList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
        List<SimpleGrantedAuthority> authorityList = umsPermissionList.stream()
                .filter(umsPermission -> umsPermission.getValue() != null)
                .map(umsPermission -> new SimpleGrantedAuthority(umsPermission.getValue()))
                .collect(Collectors.toList());
        log.info("当前登陆人的权限的是=====>:{}",authorityList);
        return authorityList;
    }

    @Override
    public String getPassword() {
        String password = umsAdmin.getPassword();
        log.info("当前登陆人的密码是=====>:{}",password);
        return password;
    }

    @Override
    public String getUsername() {
        String username = umsAdmin.getUsername();
        log.info("当前登陆人的用户名是=====>:{}",username);
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
