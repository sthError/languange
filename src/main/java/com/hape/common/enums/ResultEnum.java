package com.hape.common.enums;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@ApiOperation("响应枚举")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ResultEnum {


    @ApiModelProperty("成功响应") SUCCESS("0000", "success"), @ApiModelProperty("失败响应") FAIL("0001", "fail"), @ApiModelProperty("异常响应") ERROR("1111", "error");

    private String code;
    private String message;
}
