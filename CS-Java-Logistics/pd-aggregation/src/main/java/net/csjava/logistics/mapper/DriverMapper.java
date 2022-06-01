package net.csjava.logistics.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.csjava.logistics.DTO.AppDriverQueryDTO;
import net.csjava.logistics.DTO.DriverJobDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface DriverMapper extends BaseMapper {
    IPage<DriverJobDTO> findByPage(IPage<DriverJobDTO> iPage, @Param("params") AppDriverQueryDTO dto);
}
