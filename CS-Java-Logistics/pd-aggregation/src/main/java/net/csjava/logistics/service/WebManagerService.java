package net.csjava.logistics.service;

import net.csjava.logistics.DTO.DriverJobDTO;
import net.csjava.logistics.DTO.TaskPickupDispatchDTO;
import net.csjava.logistics.DTO.TaskTransportDTO;
import net.csjava.logistics.DTO.TransportOrderDTO;
import net.csjava.logistics.DTO.webManager.DriverJobQueryDTO;
import net.csjava.logistics.DTO.webManager.TaskPickupDispatchQueryDTO;
import net.csjava.logistics.DTO.webManager.TaskTransportQueryDTO;
import net.csjava.logistics.DTO.webManager.TransportOrderQueryDTO;
import net.csjava.logistics.common.utils.PageResponse;

public interface WebManagerService {
    /**
     * 获取司机作业单分页数据
     *
     * @param dto 查询参数
     * @return 司机作业单分页数据
     */
    PageResponse<DriverJobDTO> findDriverJobByPage(DriverJobQueryDTO dto);

    /**
     * 获取取派件任务分页数据
     *
     * @param dto 查询参数
     * @return 取派件分页数据
     */
    PageResponse<TaskPickupDispatchDTO> findTaskPickupDispatchJobByPage(TaskPickupDispatchQueryDTO dto);

    /**
     * 获取运单分页数据
     *
     * @param dto 查询参数
     * @return 运单分页数据
     */
    PageResponse<TransportOrderDTO> findTransportOrderByPage(TransportOrderQueryDTO dto);

    /**
     * 获取运输任务分页数据
     *
     * @param dto 查询参数
     * @return 运输任务分页数据
     */
    PageResponse<TaskTransportDTO> findTaskTransportByPage(TaskTransportQueryDTO dto);
}
