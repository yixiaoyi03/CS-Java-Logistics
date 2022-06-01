package net.csjava.logistics.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.csjava.logistics.entity.TaskTransport;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 运输任务表 Mapper 接口
 * </p>
 *
 * @author jpf
 * @since 2020-01-08
 */
@Mapper
public interface TaskTransportMapper extends BaseMapper<TaskTransport> {
}
