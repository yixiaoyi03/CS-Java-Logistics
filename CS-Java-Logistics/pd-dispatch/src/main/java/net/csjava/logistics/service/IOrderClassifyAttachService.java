/**
 * Copyright (c) 2019 联智合创 All rights reserved.
 * <p>
 * http://www.witlinked.com
 * <p>
 * 版权所有，侵权必究！
 */

package net.csjava.logistics.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.csjava.logistics.entity.OrderClassifyAttachEntity;

import java.util.List;

/**
 * 车次车辆司机订单分类关联
 *
 * @author
 */
public interface IOrderClassifyAttachService extends IService<OrderClassifyAttachEntity> {

    List<OrderClassifyAttachEntity> findAttachByClassifyId(String classifyId);

}
