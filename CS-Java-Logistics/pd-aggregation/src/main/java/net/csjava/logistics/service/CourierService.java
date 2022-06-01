package net.csjava.logistics.service;


import net.csjava.logistics.DTO.AppCourierQueryDTO;
import net.csjava.logistics.DTO.TaskPickupDispatchDTO;
import net.csjava.logistics.common.utils.PageResponse;

public interface CourierService {
    PageResponse<TaskPickupDispatchDTO> findByPage(AppCourierQueryDTO dto);
}
