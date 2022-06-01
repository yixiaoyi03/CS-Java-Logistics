package net.csjava.logistics.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.csjava.logistics.entity.CacheLineEntity;

/**
 * 缓冲线路
 *
 * @author
 */
public interface ICacheLineService extends IService<CacheLineEntity> {

    String check(String verifyKey);

    int saveAndUpdate(CacheLineEntity cacheLineEntity);

    Integer deleteOldAndGetNewVersion(String notEqualsLineStart, String notEqualsLineEnd);
}
