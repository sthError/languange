package com.hape.controller.web.api;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import com.hape.common.annotation.FrontLoginIgnore;
import com.hape.common.constant.CacheConstant;
import com.hape.common.enums.TokenEnum;
import com.hape.common.response.R;
import com.hape.common.response.web.WebUserRequest;
import com.hape.common.utils.LoginUtil;
import com.hape.common.utils.RedisUtil;
import com.hape.controller.web.business.FrontUserBusiness;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Api(value = "用户端用户", tags = {"用户端接口"})
@Slf4j
@FrontLoginIgnore
@RestController
@RequestMapping("/front/user")
public class FrontUserAPi {

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private LoginUtil loginUtil;
    @Resource
    private FrontUserBusiness frontUserBusiness;

    @PostMapping("/testToken")
//    @FrontLoginIgnore
    private R test(@RequestBody WebUserRequest request) {

        String token = loginUtil.getHeader(TokenEnum.front_token.getCode());
        String cache = redisUtil.get(CacheConstant.front_login + token);
        if (!StringUtils.isEmpty(cache)) {
            return R.success(cache);
        } else {
            String id = IdUtil.simpleUUID();
            log.info("token cache key:{}", CacheConstant.front_login + id);
            redisUtil.set(CacheConstant.front_login + id, id, 10L, TimeUnit.MINUTES);
        }
        return null;
    }

    @ApiOperation("个人登录")
    @PostMapping("/login")
    public R login(@RequestBody WebUserRequest request) {
        Assert.notBlank(request.getPhone(), "请输入用户名");
        Assert.notBlank(request.getPassword(), "请输入密码");
        return frontUserBusiness.login(request);
    }

    @ApiOperation("个人注册")
    @PostMapping("/register")
    public R register(@RequestBody WebUserRequest request) {
        Assert.notBlank(request.getPhone(), "请输入用户名");
        Assert.notBlank(request.getPassword(), "请输入密码");
        return frontUserBusiness.register(request);
    }
}
