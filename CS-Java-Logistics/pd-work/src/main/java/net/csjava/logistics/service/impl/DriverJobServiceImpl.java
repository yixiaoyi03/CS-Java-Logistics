package net.csjava.logistics.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.csjava.logistics.common.CustomIdGenerator;
import net.csjava.logistics.entity.DriverJob;
import net.csjava.logistics.enums.driverjob.DriverJobStatus;
import net.csjava.logistics.mapper.DriverJobMapper;
import net.csjava.logistics.service.IDriverJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DriverJobServiceImpl extends ServiceImpl<DriverJobMapper, DriverJob> implements IDriverJobService {
    @Autowired
    private CustomIdGenerator idGenerator;

    @Override
    public DriverJob saveDriverJob(DriverJob driverJob) {
        driverJob.setId(idGenerator.nextId(driverJob) + "");
        driverJob.setCreateTime(LocalDateTime.now());
        driverJob.setStatus(DriverJobStatus.PENDING.getCode());
        save(driverJob);
        return driverJob;
    }

    @Override
    public IPage<DriverJob> findByPage(Integer page, Integer pageSize, String id, String driverId, Integer status, String taskTransportId) {
        Page<DriverJob> iPage = new Page(page, pageSize);
        LambdaQueryWrapper<DriverJob> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotEmpty(id)) {
            lambdaQueryWrapper.like(DriverJob::getId, id);
        }
        if (StringUtils.isNotEmpty(driverId)) {
            lambdaQueryWrapper.eq(DriverJob::getDriverId, driverId);
        }
        if (status != null) {
            lambdaQueryWrapper.eq(DriverJob::getStatus, status);
        }
        if (StringUtils.isNotEmpty(taskTransportId)) {
            lambdaQueryWrapper.like(DriverJob::getTaskTransportId, taskTransportId);
        }
        lambdaQueryWrapper.orderByAsc(DriverJob::getCreateTime);
        return page(iPage, lambdaQueryWrapper);
    }

    @Override
    public List<DriverJob> findAll(List<String> ids, String id, String driverId, Integer status, String taskTransportId) {
        LambdaQueryWrapper<DriverJob> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (ids != null && ids.size() > 0) {
            lambdaQueryWrapper.in(DriverJob::getId, ids);
        }
        if (StringUtils.isNotEmpty(id)) {
            lambdaQueryWrapper.like(DriverJob::getId, id);
        }
        if (StringUtils.isNotEmpty(driverId)) {
            lambdaQueryWrapper.like(DriverJob::getDriverId, driverId);
        }
        if (status != null) {
            lambdaQueryWrapper.eq(DriverJob::getStatus, status);
        }
        if (StringUtils.isNotEmpty(taskTransportId)) {
            lambdaQueryWrapper.like(DriverJob::getTaskTransportId, taskTransportId);
        }
        lambdaQueryWrapper.orderByDesc(DriverJob::getCreateTime);
        return list(lambdaQueryWrapper);
    }
}
