package net.csjava.logistics.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.csjava.logistics.entity.DriverJob;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 司机作业单 Mapper 接口
 * </p>
 */
@Mapper
public interface DriverJobMapper extends BaseMapper<DriverJob> {
}
