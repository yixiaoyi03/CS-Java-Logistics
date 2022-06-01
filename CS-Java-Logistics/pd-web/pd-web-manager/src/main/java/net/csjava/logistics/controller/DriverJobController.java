package net.csjava.logistics.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.csjava.logistics.DTO.DriverJobDTO;
import net.csjava.logistics.DTO.webManager.DriverJobQueryDTO;
import net.csjava.logistics.common.utils.PageResponse;
import net.csjava.logistics.feign.OrderFeign;
import net.csjava.logistics.feign.TransportOrderFeign;
import net.csjava.logistics.feign.TransportTaskFeign;
import net.csjava.logistics.feign.transportline.TransportTripsFeign;
import net.csjava.logistics.feign.truck.TruckFeign;
import net.csjava.logistics.feign.webManager.WebManagerFeign;
import net.csjava.logistics.util.BeanUtil;
import net.csjava.logistics.vo.work.DriverJobVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 司机作业单相关API
 *
 * @author itcast
 */
@RestController
@Slf4j
@Api(tags = "司机作业单相关API")
@RequestMapping("driver-job-manager")
public class DriverJobController {
    @Autowired
    private WebManagerFeign webManagerFeign;
    @Autowired
    private TransportTaskFeign transportTaskFeign;
    @Autowired
    private TransportTripsFeign transportTripsFeign;
    @Autowired
    private OrgApi orgApi;
    @Autowired
    private UserApi userApi;
    @Autowired
    private TruckFeign truckFeign;
    @Autowired
    private TransportOrderFeign transportOrderFeign;
    @Autowired
    private OrderFeign orderFeign;
    @Autowired
    private AreaApi areaApi;

    @ApiOperation(value = "获取司机作业单分页数据")
    @PostMapping("/page")
    public PageResponse<DriverJobVo> findByPage(@RequestBody DriverJobVo vo) {
        DriverJobQueryDTO dto = new DriverJobQueryDTO();
        if (vo != null) {
            dto.setPage(vo.getPage());
            dto.setPageSize(vo.getPageSize());
            if (vo.getDriver() != null) {
                dto.setDriverName(vo.getDriver().getName());
            }
            if (vo.getTaskTransport() != null) {
                dto.setTaskTransportId(vo.getTaskTransport().getId());
            }
            dto.setStatus(vo.getStatus());
            dto.setId(vo.getId());
        }
        PageResponse<DriverJobDTO> dtoPageResponse = webManagerFeign.findDriverJobByPage(dto);
        List<DriverJobDTO> dtoList = dtoPageResponse.getItems();
        List<DriverJobVo> voList = dtoList.stream().map(driverJobDTO -> BeanUtil.parseDriverJobDTO2Vo(driverJobDTO, transportTripsFeign, orgApi, userApi, truckFeign, transportOrderFeign, orderFeign, areaApi, transportTaskFeign)).collect(Collectors.toList());
        return PageResponse.<DriverJobVo>builder().items(voList).pagesize(vo.getPageSize()).page(vo.getPage()).counts(dtoPageResponse.getCounts()).pages(dtoPageResponse.getPages()).build();
    }
}
