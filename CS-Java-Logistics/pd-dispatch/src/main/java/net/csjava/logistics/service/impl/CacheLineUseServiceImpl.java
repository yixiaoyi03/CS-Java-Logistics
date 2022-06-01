/**
 * Copyright (c) 2019 联智合创 All rights reserved.
 * <p>
 * http://www.witlinked.com
 * <p>
 * 版权所有，侵权必究！
 */

package net.csjava.logistics.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.csjava.logistics.entity.CacheLineUseEntity;
import net.csjava.logistics.mapper.CacheLineUseMapper;
import net.csjava.logistics.service.ICacheLineUseService;
import org.springframework.stereotype.Service;

@Service
public class CacheLineUseServiceImpl extends ServiceImpl<CacheLineUseMapper, CacheLineUseEntity> implements ICacheLineUseService {

    @Override
    public CacheLineUseEntity getByOrderClassifyId(String id) {
        LambdaQueryWrapper<CacheLineUseEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CacheLineUseEntity::getOrderClassifyId, id);
        return this.baseMapper.selectOne(wrapper);
    }
}