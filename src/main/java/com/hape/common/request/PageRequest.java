package com.hape.common.request;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiOperation("公共参数-分页")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequest {

    @ApiModelProperty("目标页数")
    private Integer pageNum = 1;

    @ApiModelProperty("目标页大小")
    private Integer pageSize = 10;
}
