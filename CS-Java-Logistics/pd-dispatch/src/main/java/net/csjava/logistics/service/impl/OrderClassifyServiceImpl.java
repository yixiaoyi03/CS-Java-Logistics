package net.csjava.logistics.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.csjava.logistics.entity.OrderClassifyEntity;
import net.csjava.logistics.mapper.OrderClassifyMapper;
import net.csjava.logistics.service.IOrderClassifyService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderClassifyServiceImpl extends ServiceImpl<OrderClassifyMapper, OrderClassifyEntity> implements IOrderClassifyService {
    @Override
    public List<OrderClassifyEntity> findByJobLogId(String id) {
        LambdaQueryWrapper<OrderClassifyEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(OrderClassifyEntity::getJobLogId, id);
        return this.baseMapper.selectList(wrapper);
    }
}