package net.csjava.logistics.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.csjava.logistics.DTO.DriverJobDTO;
import net.csjava.logistics.DTO.TaskPickupDispatchDTO;
import net.csjava.logistics.DTO.TaskTransportDTO;
import net.csjava.logistics.DTO.TransportOrderDTO;
import net.csjava.logistics.DTO.webManager.DriverJobQueryDTO;
import net.csjava.logistics.DTO.webManager.TaskPickupDispatchQueryDTO;
import net.csjava.logistics.DTO.webManager.TaskTransportQueryDTO;
import net.csjava.logistics.DTO.webManager.TransportOrderQueryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface WebManagerMapper extends BaseMapper {
    IPage<DriverJobDTO> findDriverJobByPage(IPage<DriverJobDTO> iPage, @Param("params") DriverJobQueryDTO dto);

    IPage<TaskPickupDispatchDTO> findTaskPickupDispatchJobByPage(IPage<TaskPickupDispatchDTO> iPage, @Param("params") TaskPickupDispatchQueryDTO dto);

    IPage<TransportOrderDTO> findTransportOrderByPage(IPage<TransportOrderDTO> iPage, @Param("params") TransportOrderQueryDTO dto);

    IPage<TaskTransportDTO> findTaskTransportByPage(IPage<TaskTransportDTO> iPage, @Param("params") TaskTransportQueryDTO dto);
}
