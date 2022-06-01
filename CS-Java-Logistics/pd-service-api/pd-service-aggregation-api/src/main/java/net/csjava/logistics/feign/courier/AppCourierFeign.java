package net.csjava.logistics.feign.courier;


import net.csjava.logistics.DTO.AppCourierQueryDTO;
import net.csjava.logistics.DTO.TaskPickupDispatchDTO;
import net.csjava.logistics.common.utils.PageResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@FeignClient(name = "pd-aggregation")
@RequestMapping("appCourier")
@ApiIgnore
public interface AppCourierFeign {
    /**
     * 分页查询快递员任务
     *
     * @param dto
     * @return
     */
    @PostMapping("page")
    PageResponse<TaskPickupDispatchDTO> findByPage(@RequestBody AppCourierQueryDTO dto);

}
