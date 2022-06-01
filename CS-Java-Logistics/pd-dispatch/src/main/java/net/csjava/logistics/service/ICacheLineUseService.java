package net.csjava.logistics.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.csjava.logistics.entity.CacheLineUseEntity;

/**
 * 缓冲使用表
 *
 * @author
 */
public interface ICacheLineUseService extends IService<CacheLineUseEntity> {

    CacheLineUseEntity getByOrderClassifyId(String id);
}
