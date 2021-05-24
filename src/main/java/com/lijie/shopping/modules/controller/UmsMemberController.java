package com.lijie.shopping.modules.controller;


import com.lijie.shopping.common.CommonResult;
import com.lijie.shopping.modules.service.UmsMemberService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author lijie
 * @since 2021-05-13
 */
@RestController
@RequestMapping("/modules/umsMember")
@Slf4j
public class UmsMemberController {

    @Autowired
    private UmsMemberService memberService;

    @ApiOperation("获取验证码")
    @GetMapping(value = "/getAuthCode")
    public CommonResult getAuthCode(@RequestParam String telephone) {
        try {
            String authCode = memberService.getAuthCode(telephone);
            return CommonResult.success(authCode,"操作成功");
        } catch (Exception e) {
            log.error("系统异常{}", e);
            return CommonResult.failed("系统异常");
        }
    }

}

