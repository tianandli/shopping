package com.lijie.shopping.modules.controller;


import com.lijie.shopping.common.CommonResult;
import com.lijie.shopping.dto.UmsAdminLoginDto;
import com.lijie.shopping.modules.model.UmsAdmin;
import com.lijie.shopping.modules.model.UmsAdminLoginLog;
import com.lijie.shopping.modules.model.UmsPermission;
import com.lijie.shopping.modules.service.UmsAdminLoginLogService;
import com.lijie.shopping.modules.service.UmsAdminService;
import com.lijie.shopping.modules.service.UmsPermissionService;
import com.lijie.shopping.param.UmsAdminLoginDtoAdd;
import com.lijie.shopping.springsecurity.AdminUserDetails;
import com.lijie.shopping.utils.CheckParamUtil;
import com.lijie.shopping.utils.JwtTokenUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author lijie
 * @since 2021-05-13
 */
@RestController
@RequestMapping("/modules/umsAdmin")
@Slf4j
public class UmsAdminController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UmsAdminService umsAdminService;
    @Autowired
    private UmsPermissionService umsPermissionService;
    @Autowired
    private UmsAdminLoginLogService umsAdminLoginLogService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "登录并返回token")
    @PostMapping(value = "/login")
    public CommonResult login(@RequestBody UmsAdminLoginDto umsAdminLoginDto) {
        try {
            //参数校验
            String res = CheckParamUtil.checkparam(umsAdminLoginDto, UmsAdminLoginDtoAdd.class);
            if (res != null) {
                return CommonResult.failed(res);
            }

            UmsAdmin umsAdmin = umsAdminService.getAdminByUsername(umsAdminLoginDto.getUsername());
            if (umsAdmin == null) {
                return CommonResult.failed("用户名错误");
            }
            List<UmsPermission> umsPermissionList = umsPermissionService.getPermissionsByAdminId(umsAdmin.getId());
            if (umsPermissionList == null) {
                return CommonResult.failed("查找管理员权限报错");
            }
            AdminUserDetails adminUserDetails = new AdminUserDetails(umsAdmin, umsPermissionList);
            if (!passwordEncoder.matches(umsAdminLoginDto.getPassword(), adminUserDetails.getPassword())) {
                return CommonResult.failed("密码不正确");
            }
            // 1 创建UsernamePasswordAuthenticationToken，并认证
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken
                    (adminUserDetails, null, adminUserDetails.getAuthorities());
            // 2 保存认证信息
            SecurityContextHolder.getContext().setAuthentication(authentication);
            // 3 生成自定义token
            String token = jwtTokenUtil.generateToken(adminUserDetails);
            if (StringUtils.isBlank(token)) {
                return CommonResult.failed("生成token错误");
            }
            //插入日志
            UmsAdminLoginLog umsAdminLoginLog = new UmsAdminLoginLog();
            umsAdminLoginLog.setAdminId(umsAdmin.getId());
            umsAdminLoginLog.setCreateTime(new Date());
            umsAdminLoginLog.setIp(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()
                    .getRemoteAddr());
            umsAdminLoginLogService.save(umsAdminLoginLog);

            return CommonResult.success(tokenHead+token);
        } catch (Exception e) {
            log.error("系统异常:{}", e.getMessage());
            return CommonResult.failed("系统异常");
        }
    }

    @ApiOperation(value = "获取当前登陆人的所有权限")
    @GetMapping(value = "/getPermissions")
    public CommonResult getPermissions(@RequestParam Long adminId) {
        try {
            List<UmsPermission> umsPermissionList = umsPermissionService.getPermissionsByAdminId(adminId);
            return CommonResult.success(umsPermissionList);
        } catch (Exception e) {
            log.error("系统异常:{}", e.getMessage());
            return CommonResult.failed("系统异常");
        }
    }
}

