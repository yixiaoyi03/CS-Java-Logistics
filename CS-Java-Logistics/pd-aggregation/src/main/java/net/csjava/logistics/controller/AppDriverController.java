package net.csjava.logistics.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import net.csjava.logistics.DTO.AppDriverQueryDTO;
import net.csjava.logistics.DTO.DriverJobDTO;
import net.csjava.logistics.common.utils.PageResponse;
import net.csjava.logistics.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "司机聚合平台")
@RestController
@RequestMapping("appDriver")
public class AppDriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/page")
    PageResponse<DriverJobDTO> findByPage(@RequestBody AppDriverQueryDTO dto) {
        return driverService.findByPage(dto);
    }
}
