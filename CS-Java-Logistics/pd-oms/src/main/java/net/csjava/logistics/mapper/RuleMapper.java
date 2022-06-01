package net.csjava.logistics.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.csjava.logistics.entity.Rule;
import org.apache.ibatis.annotations.Mapper;

/**
 * 规则
 */
@Mapper
public interface RuleMapper extends BaseMapper<Rule> {
}