package com.hape.common.enums;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@ApiOperation("状态枚举")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum StatusEnum {

    NO("0", "否定"),

    YES("1", "肯定"),
    ;

    private String code;
    private String desc;
}
