

package net.csjava.logistics.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.csjava.logistics.entity.OrderClassifyAttachEntity;
import net.csjava.logistics.mapper.OrderClassifyAttachMapper;
import net.csjava.logistics.service.IOrderClassifyAttachService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderClassifyAttachServiceImpl extends ServiceImpl<OrderClassifyAttachMapper, OrderClassifyAttachEntity> implements IOrderClassifyAttachService {

    @Override
    public List<OrderClassifyAttachEntity> findAttachByClassifyId(String classifyId) {

        LambdaQueryWrapper<OrderClassifyAttachEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(OrderClassifyAttachEntity::getOrderClassifyId, classifyId);

        // 正序排列  从先到后
        wrapper.orderByAsc(OrderClassifyAttachEntity::getCreateDate);
        return this.baseMapper.selectList(wrapper);
    }
}