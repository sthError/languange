package com.hape.dao.back.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hape.dao.back.po.BackUserPO;
import com.hape.dao.back.mapper.BackUserMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后管用户 服务实现类
 * </p>
 *
 * @author hape
 * @since 2024-01-22
 */
@Service
public class BackUserServiceImpl extends ServiceImpl<BackUserMapper, BackUserPO> implements BackUserService {

}
