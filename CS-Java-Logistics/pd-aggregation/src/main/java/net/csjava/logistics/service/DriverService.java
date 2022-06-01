package net.csjava.logistics.service;

import com.itheima.pinda.DTO.AppDriverQueryDTO;
import com.itheima.pinda.DTO.DriverJobDTO;
import com.itheima.pinda.common.utils.PageResponse;

public interface DriverService {
    PageResponse<DriverJobDTO> findByPage(AppDriverQueryDTO dto);
}
