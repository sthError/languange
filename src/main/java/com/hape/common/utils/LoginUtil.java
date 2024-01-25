package com.hape.common.utils;

import com.hape.common.constant.CacheConstant;
import com.hape.common.exception.BusinessException;
import com.hape.dao.back.po.BackUserPO;
import com.hape.dao.back.service.BackUserService;
import com.hape.dao.web.po.FrontUserPO;
import com.hape.dao.web.service.FrontUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;

@Slf4j
@Component
public class LoginUtil {

    @Resource
    private FrontUserService frontUserService;

    @Resource
    private BackUserService backUserService;

    @Resource
    private RedisUtil redisUtil;

    public FrontUserPO getFront(String token) {
        String id = redisUtil.get(CacheConstant.front_login + token);
        if (StringUtils.isEmpty(id)) {
            throw new BusinessException("未登录或已过期，请重新登录");
        }
        return getFrontById(id);
    }

    public FrontUserPO getFrontById(String id) {
        FrontUserPO userPO = frontUserService.getById(id);
        if (userPO == null) {
            throw new BusinessException("用户不存在");
        }
        return userPO;
    }

    public BackUserPO getBack(String token) {
        String id = redisUtil.get(CacheConstant.back_login + token);
        if (StringUtils.isEmpty(id)) {
            throw new BusinessException("未登录或已过期，请重新登录");
        }
        return getBackById(id);
    }

    public BackUserPO getBackById(String id) {
        BackUserPO userPO = backUserService.getById(id);
        if (userPO == null) {
            throw new BusinessException("用户不存在");
        }
        return userPO;
    }

    public String getHeader(String token) {
        ServletRequestAttributes context = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String str = context.getRequest().getHeader(token);
        return str;
    }
}
