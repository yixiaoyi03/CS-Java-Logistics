package net.csjava.logistics.service;


import net.csjava.logistics.DTO.AppDriverQueryDTO;
import net.csjava.logistics.DTO.DriverJobDTO;
import net.csjava.logistics.common.utils.PageResponse;

public interface DriverService {
    PageResponse<DriverJobDTO> findByPage(AppDriverQueryDTO dto);
}
