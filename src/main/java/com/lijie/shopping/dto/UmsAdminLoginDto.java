package com.lijie.shopping.dto;

import com.lijie.shopping.param.UmsAdminLoginDtoAdd;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * 管理员登录时入参的dto
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UmsAdminLoginDto {

    @ApiModelProperty(value = "用户名", required = true)
    @NotNull(groups = {UmsAdminLoginDtoAdd.class})
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    @NotNull(groups = {UmsAdminLoginDtoAdd.class})
    private String password;
}
