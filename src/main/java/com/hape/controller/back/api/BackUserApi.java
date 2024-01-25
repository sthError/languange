package com.hape.controller.back.api;

import cn.hutool.core.lang.Assert;
import com.hape.common.annotation.BackLoginIgnore;
import com.hape.common.response.R;
import com.hape.controller.back.business.BackUserBusiness;
import com.hape.controller.back.request.BackUserRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(value = "后管用户", tags = {"后管用户"})
@RestController
@RequestMapping("/back/user")
public class BackUserApi {

    @Resource
    private BackUserBusiness backUserService;

    @ApiOperation("后管登录")
    @BackLoginIgnore
    @PostMapping("/login")
    public R login(@RequestBody BackUserRequest request) {
        Assert.notBlank(request.getPhone(), "请输入用户名");
        Assert.notBlank(request.getPassword(), "请输入密码");
        return backUserService.login(request);
    }

    @ApiOperation("后管注册")
    @BackLoginIgnore
    @PostMapping("/register")
    public R register(@RequestBody BackUserRequest request) {
        Assert.notBlank(request.getPhone(), "请输入用户名");
        Assert.notBlank(request.getPassword(), "请输入密码");
        return backUserService.register(request);
    }
}
