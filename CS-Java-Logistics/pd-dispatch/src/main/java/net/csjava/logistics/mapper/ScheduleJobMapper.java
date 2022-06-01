package net.csjava.logistics.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.pinda.entity.Order;
import net.csjava.logistics.entity.ScheduleJobEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 定时任务  Mapper 接口
 */
@Component
@Mapper
public interface ScheduleJobMapper extends BaseMapper<ScheduleJobEntity> {

}
