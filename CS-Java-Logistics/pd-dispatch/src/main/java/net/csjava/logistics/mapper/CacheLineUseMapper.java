package net.csjava.logistics.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.csjava.logistics.entity.CacheLineUseEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface CacheLineUseMapper extends BaseMapper<CacheLineUseEntity> {
}
