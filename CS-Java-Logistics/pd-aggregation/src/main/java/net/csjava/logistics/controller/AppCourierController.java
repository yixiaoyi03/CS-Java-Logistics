package net.csjava.logistics.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import net.csjava.logistics.DTO.AppCourierQueryDTO;
import net.csjava.logistics.DTO.TaskPickupDispatchDTO;
import net.csjava.logistics.common.utils.PageResponse;
import net.csjava.logistics.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "快递员聚合平台")
@RestController
@RequestMapping("appCourier")
public class AppCourierController {

    @Autowired
    private CourierService courierService;

    @PostMapping("/page")
    PageResponse<TaskPickupDispatchDTO> findByPage(@RequestBody AppCourierQueryDTO dto) {
        return courierService.findByPage(dto);
    }
}
