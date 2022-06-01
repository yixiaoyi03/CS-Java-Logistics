package net.csjava.logistics.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.csjava.logistics.entity.OrderLocation;
import net.csjava.logistics.mapper.OrderLocationMapper;
import net.csjava.logistics.service.IOrderLocationService;
import org.springframework.stereotype.Service;

/**
 * 位置信息服务实现
 */
@Service
public class OrderLocationServiceImpl extends ServiceImpl<OrderLocationMapper, OrderLocation> implements IOrderLocationService {

}