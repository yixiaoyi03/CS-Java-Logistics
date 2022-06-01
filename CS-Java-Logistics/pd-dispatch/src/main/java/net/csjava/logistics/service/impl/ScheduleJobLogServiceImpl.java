package net.csjava.logistics.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.csjava.logistics.DTO.ScheduleJobLogDTO;
import net.csjava.logistics.entity.ScheduleJobLogEntity;
import net.csjava.logistics.mapper.ScheduleJobLogMapper;
import net.csjava.logistics.service.IScheduleJobLogService;
import net.csjava.logistics.utils.ConvertUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class ScheduleJobLogServiceImpl extends ServiceImpl<ScheduleJobLogMapper, ScheduleJobLogEntity> implements IScheduleJobLogService {

    @Override
    public IPage<ScheduleJobLogEntity> page(Map<String, Object> params) {
        IPage<ScheduleJobLogEntity> page = new Page<>();
        page.setCurrent(Long.parseLong(params.get("page").toString()));
        page.setSize(Long.parseLong(params.get("pageSize").toString()));

        LambdaQueryWrapper<ScheduleJobLogEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(params.containsKey("jobId"), ScheduleJobLogEntity::getJobId, params.get("jobId"));
        wrapper.orderByDesc(ScheduleJobLogEntity::getCreateDate);
        return this.baseMapper.selectPage(page,wrapper);
    }

    private QueryWrapper<ScheduleJobLogEntity> getWrapper(Map<String, Object> params) {
        String jobId = (String) params.get("jobId");

        QueryWrapper<ScheduleJobLogEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(jobId), "job_id", jobId);

        return wrapper;
    }

    @Override
    public ScheduleJobLogDTO get(Long id) {
        ScheduleJobLogEntity entity = baseMapper.selectById(id);

        return ConvertUtils.sourceToTarget(entity, ScheduleJobLogDTO.class);
    }

}