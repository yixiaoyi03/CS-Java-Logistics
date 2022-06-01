package net.csjava.logistics.DTO;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import net.csjava.logistics.entity.ScheduleJobEntity;

/**
 * 定时任务
 *
 * @author
 * @since 1.0.0
 */
@Data
@ApiModel(value = "定时任务")
public class ScheduleJobDTO extends ScheduleJobEntity {

}
