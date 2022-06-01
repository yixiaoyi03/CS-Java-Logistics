

package net.csjava.logistics.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.csjava.logistics.entity.CacheLineDetailEntity;

import java.util.List;

/**
 * 缓冲线路子表
 *
 * @author
 */
public interface ICacheLineDetailService extends IService<CacheLineDetailEntity> {

    List<CacheLineDetailEntity> findByCacheLineId(String cacheLineId);
}
