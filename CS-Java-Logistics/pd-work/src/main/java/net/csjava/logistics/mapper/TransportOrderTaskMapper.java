package net.csjava.logistics.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.csjava.logistics.entity.TransportOrderTask;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 运单与运输任务表 Mapper 接口
 * </p>
 */
@Mapper
public interface TransportOrderTaskMapper extends BaseMapper<TransportOrderTask> {
}
