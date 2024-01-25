package com.hape.dao.web.service;

import com.hape.dao.web.po.FrontUserPO;
import com.hape.dao.web.mapper.FrontUserMapper;
import com.hape.dao.web.service.FrontUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 个人端用户 服务实现类
 * </p>
 *
 * @author hape
 * @since 2024-01-22
 */
@Service
public class FrontUserServiceImpl extends ServiceImpl<FrontUserMapper, FrontUserPO> implements FrontUserService {

}
