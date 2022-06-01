package net.csjava.logistics.service;
import com.baomidou.mybatisplus.extension.service.IService;
import net.csjava.logistics.entity.OrderClassifyEntity;

import java.util.List;

/**
 * 订单分类
 */
public interface IOrderClassifyService extends IService<OrderClassifyEntity> {
    List<OrderClassifyEntity> findByJobLogId(String id);
}