package net.csjava.logistics.DTO;


import net.csjava.logistics.entity.ScheduleJobLogEntity;

import java.util.List;

/**
 * 定时任务日志
 *
 * @author
 * @since 1.0.0
 */
@Data
@ApiModel(value = "定时任务日志")
public class ScheduleJobLogDTO extends ScheduleJobLogEntity {

    List<OrderClassifyLogDTO> orderClassifyLogDTOS;
}
