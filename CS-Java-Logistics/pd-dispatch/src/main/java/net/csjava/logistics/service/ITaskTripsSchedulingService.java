package net.csjava.logistics.service;

import net.csjava.logistics.DTO.OrderLineSimpleDTO;
import net.csjava.logistics.DTO.OrderLineTripsTruckDriverDTO;

import java.util.List;

/**
 * 车辆调度
 */
public interface ITaskTripsSchedulingService {
    /**
     * 执行
     *
     * @param orderLineSimpleDTOS
     * @param businessId
     * @param jobId
     * @param logId
     * @return
     */
    List<OrderLineTripsTruckDriverDTO> execute(List<OrderLineSimpleDTO> orderLineSimpleDTOS, String businessId, String jobId, String logId, String agencyId);
}
