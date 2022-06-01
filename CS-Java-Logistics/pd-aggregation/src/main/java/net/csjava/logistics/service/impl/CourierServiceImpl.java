package net.csjava.logistics.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.csjava.logistics.DTO.AppCourierQueryDTO;
import net.csjava.logistics.DTO.TaskPickupDispatchDTO;
import net.csjava.logistics.common.utils.PageResponse;
import net.csjava.logistics.mapper.CourierMapper;
import net.csjava.logistics.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourierServiceImpl implements CourierService {

    @Autowired
    private CourierMapper courierMapper;

    @Override
    public PageResponse<TaskPickupDispatchDTO> findByPage(AppCourierQueryDTO dto) {
        IPage<TaskPickupDispatchDTO> iPage = new Page();
        iPage.setSize(dto.getPageSize());
        iPage.setCurrent(dto.getPage());
        courierMapper.findByPage(iPage, dto);

        return PageResponse.<TaskPickupDispatchDTO>builder()
                .counts(iPage.getTotal())
                .pages(iPage.getPages())
                .pagesize(dto.getPageSize())
                .page(dto.getPage())
                .items(iPage.getRecords())
                .build();
    }
}
