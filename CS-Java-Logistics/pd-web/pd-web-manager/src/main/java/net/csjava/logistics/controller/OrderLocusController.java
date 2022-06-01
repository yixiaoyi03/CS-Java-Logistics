package net.csjava.logistics.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.csjava.logistics.DTO.TaskPickupDispatchDTO;
import net.csjava.logistics.DTO.TaskTransportDTO;
import net.csjava.logistics.DTO.TransportOrderDTO;
import net.csjava.logistics.enums.pickuptask.PickupDispatchTaskType;
import net.csjava.logistics.feign.PickupDispatchTaskFeign;
import net.csjava.logistics.feign.TransportOrderFeign;
import net.csjava.logistics.feign.TransportTaskFeign;
import net.csjava.logistics.vo.oms.OrderLocusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * 定时任务
 *
 * @author
 */
@RestController
@RequestMapping("/orderLocus")
@Api(tags = "订单轨迹")
@Slf4j
public class OrderLocusController {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private TransportOrderFeign transportOrderFeign;

    @Autowired
    private TransportTaskFeign transportTaskFeign;

    @Autowired
    private PickupDispatchTaskFeign pickupDispatchTaskFeign;

    @GetMapping("{id}")
    @ApiOperation("查询订单轨迹参数")
    public List<OrderLocusVo> findLocusByOrderId(@PathVariable("id") String id) {
        List<OrderLocusVo> orderLocusVos = new ArrayList<>();
        // 根据订单号查询快递员取件任务
        TaskPickupDispatchDTO pickupDispatchTaskDto = pickupDispatchTaskFeign.findByOrderId(id, PickupDispatchTaskType.PICKUP.getCode());
        log.info("订单轨迹-取件任务：{}", pickupDispatchTaskDto);
        if (pickupDispatchTaskDto != null) {
            OrderLocusVo orderLocusVo = new OrderLocusVo();

            orderLocusVo.setBusinessId(pickupDispatchTaskDto.getCourierId());
            orderLocusVo.setGe___time(dtf.format(pickupDispatchTaskDto.getCreateTime())); // 起始时间设置成任务创建时间
            if (pickupDispatchTaskDto.getActualEndTime() == null) {
                orderLocusVo.setLe___time(dtf.format(LocalDateTime.now()));
            } else {
                orderLocusVo.setLe___time(dtf.format(pickupDispatchTaskDto.getActualEndTime()));
            }
            orderLocusVos.add(orderLocusVo);
        }


        // 根据订单号 查询运单信息
        TransportOrderDTO transportOrderDto = transportOrderFeign.findByOrderId(id);
        log.info("订单轨迹-运输任务：{}", transportOrderDto);
        if (transportOrderDto != null) {
            List<TaskTransportDTO> transportTaskDto = transportTaskFeign.findAllByOrderIdOrTaskId(transportOrderDto.getId(), null);

            for (TaskTransportDTO taskTransportDTO : transportTaskDto) {
                OrderLocusVo orderLocusVo = new OrderLocusVo();
                orderLocusVo.setTransportTaskId(taskTransportDTO.getId());
                orderLocusVos.add(orderLocusVo);
            }
        }

        // 根据订单号查询快递员派件任务
        TaskPickupDispatchDTO pickupDispatchTaskPushDto = pickupDispatchTaskFeign.findByOrderId(id, PickupDispatchTaskType.DISPATCH.getCode());
        log.info("订单轨迹-派件任务：{}", pickupDispatchTaskPushDto);
        if (pickupDispatchTaskPushDto != null) {
            OrderLocusVo orderLocusVo = new OrderLocusVo();

            orderLocusVo.setBusinessId(pickupDispatchTaskPushDto.getCourierId());
            orderLocusVo.setGe___time(dtf.format(pickupDispatchTaskPushDto.getCreateTime())); // 起始时间设置成任务创建时间
            if (pickupDispatchTaskPushDto.getActualEndTime() == null) {
                orderLocusVo.setLe___time(dtf.format(LocalDateTime.now()));
            } else {
                orderLocusVo.setLe___time(dtf.format(pickupDispatchTaskPushDto.getActualEndTime()));
            }
            orderLocusVos.add(orderLocusVo);
        }

        log.info("订单轨迹-轨迹参数：{}", orderLocusVos);
        return orderLocusVos;
    }
}