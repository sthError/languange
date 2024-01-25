package com.hape.controller.back.business;

import cn.hutool.core.util.IdUtil;
import com.hape.common.constant.CacheConstant;
import com.hape.common.exception.BusinessException;
import com.hape.common.response.R;
import com.hape.common.utils.RedisUtil;
import com.hape.controller.back.request.BackUserRequest;
import com.hape.dao.back.po.BackUserPO;
import com.hape.dao.back.service.BackUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class BackUserBusiness {

    @Resource
    private BackUserService backUserService;

    @Resource
    private RedisUtil redisUtil;

    public R login(BackUserRequest request) {
        BackUserPO userPO = backUserService.lambdaQuery()
                .eq(BackUserPO::getPhone, request.getPhone())
                .eq(BackUserPO::getPassword, request.getPassword())
                .one();
        if (userPO != null) {
            String token = IdUtil.fastSimpleUUID();
            redisUtil.set(CacheConstant.back_login + userPO.getId(), token);
            return R.success(token);
        } else {
            throw new BusinessException("账号或密码错误");
        }
    }

    public R register(BackUserRequest request) {
        BackUserPO userPO = backUserService.lambdaQuery().eq(BackUserPO::getPhone, request.getPhone()).one();
        if (userPO!=null){
            throw new BusinessException("手机号已被注册");
        }
        BackUserPO po = BackUserPO.builder()
                .phone(request.getPhone())
                .password(request.getPassword())
                .build();
        backUserService.save(po);
        return R.success();
    }
}
