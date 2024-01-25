package com.hape.controller.web.business;

import cn.hutool.core.util.IdUtil;
import com.hape.common.constant.CacheConstant;
import com.hape.common.exception.BusinessException;
import com.hape.common.response.R;
import com.hape.common.response.web.WebUserRequest;
import com.hape.common.utils.RedisUtil;
import com.hape.dao.web.po.FrontUserPO;
import com.hape.dao.web.service.FrontUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class FrontUserBusiness {

    @Resource
    private FrontUserService frontUserService;

    @Resource
    private RedisUtil redisUtil;

    public R login(WebUserRequest request) {
        FrontUserPO userPO = frontUserService.lambdaQuery().eq(FrontUserPO::getPhone, request.getPhone()).eq(FrontUserPO::getPassword, request.getPassword()).one();
        if (userPO == null) {
            throw new BusinessException("账号或密码错误");
        }

        String id = userPO.getId().toString();
        String token = CacheConstant.front_login + IdUtil.simpleUUID();
        redisUtil.set(token, id, 30L, TimeUnit.MINUTES);
        return R.success(token);
    }

    @Transactional
    public R register(WebUserRequest request) {
        FrontUserPO userPO = frontUserService.lambdaQuery().eq(FrontUserPO::getPhone, request.getPhone()).one();
        if (userPO != null) {
            throw new BusinessException("手机号已绑定用户");
        }

        FrontUserPO build = FrontUserPO.builder().phone(request.getPhone()).password(request.getPassword()).build();
        frontUserService.save(build);

        return R.success();
    }
}
