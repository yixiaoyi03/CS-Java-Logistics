package net.csjava.logistics.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.csjava.logistics.entity.OrderClassifyOrderEntity;
import net.csjava.logistics.mapper.OrderClassifyOrderMapper;
import net.csjava.logistics.service.IOrderClassifyOrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderClassifyOrderServiceImpl extends ServiceImpl<OrderClassifyOrderMapper, OrderClassifyOrderEntity> implements IOrderClassifyOrderService {
    @Override
    public String getClassifyId(String orderId) {
        LambdaQueryWrapper<OrderClassifyOrderEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(OrderClassifyOrderEntity::getOrderId, orderId);

        OrderClassifyOrderEntity entity = this.baseMapper.selectOne(wrapper);

        return entity.getOrderClassifyId();
    }
}
