package com.hape.common.annotation;

import io.swagger.annotations.ApiOperation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: hape
 * @Date: 2023/2/20 17:15
 */
@ApiOperation("个人端登录忽略注解")
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface FrontLoginIgnore {
}
