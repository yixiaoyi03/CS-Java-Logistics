package net.csjava.logistics.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.csjava.logistics.entity.OrderLocation;
import org.apache.ibatis.annotations.Mapper;

/**
 * 位置信息
 */
@Mapper
public interface OrderLocationMapper extends BaseMapper<OrderLocation> {
}
