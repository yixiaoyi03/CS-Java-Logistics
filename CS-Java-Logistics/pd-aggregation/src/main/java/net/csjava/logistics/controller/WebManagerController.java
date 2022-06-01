package net.csjava.logistics.controller;


import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import net.csjava.logistics.DTO.DriverJobDTO;
import net.csjava.logistics.DTO.TaskPickupDispatchDTO;
import net.csjava.logistics.DTO.TaskTransportDTO;
import net.csjava.logistics.DTO.TransportOrderDTO;
import net.csjava.logistics.DTO.webManager.DriverJobQueryDTO;
import net.csjava.logistics.DTO.webManager.TaskPickupDispatchQueryDTO;
import net.csjava.logistics.DTO.webManager.TaskTransportQueryDTO;
import net.csjava.logistics.DTO.webManager.TransportOrderQueryDTO;
import net.csjava.logistics.common.utils.PageResponse;
import net.csjava.logistics.service.WebManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "管理后台聚合平台")
@RestController
@RequestMapping("webManager")
public class WebManagerController {
    @Autowired
    private WebManagerService webManagerService;

    @PostMapping("driverJob/page")
    PageResponse<DriverJobDTO> findDriverJobByPage(@RequestBody DriverJobQueryDTO dto) {
        return webManagerService.findDriverJobByPage(dto);
    }

    @PostMapping("taskPickupDispatchJob/page")
    PageResponse<TaskPickupDispatchDTO> findTaskPickupDispatchJobByPage(@RequestBody TaskPickupDispatchQueryDTO dto) {
        return webManagerService.findTaskPickupDispatchJobByPage(dto);
    }

    @PostMapping("transportOrder/page")
    PageResponse<TransportOrderDTO> findTransportOrderByPage(@RequestBody TransportOrderQueryDTO dto) {
        return webManagerService.findTransportOrderByPage(dto);
    }

    @PostMapping("taskTransport/page")
    PageResponse<TaskTransportDTO> findTransportOrderByPage(@RequestBody TaskTransportQueryDTO dto) {
        return webManagerService.findTaskTransportByPage(dto);
    }
}
