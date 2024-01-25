package com.hape.common.enums;


import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@ApiOperation("登录类型枚举")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum TokenEnum {

    front_token("token", "个人端token"),
    back_token("auth_token", "后管token"),
    ;

    private String code;
    private String desc;

}
