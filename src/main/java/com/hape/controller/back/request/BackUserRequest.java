package com.hape.controller.back.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BackUserRequest {

    @ApiModelProperty("手机号")
    private String phone;
    @ApiModelProperty("密码")
    private String password;
}
