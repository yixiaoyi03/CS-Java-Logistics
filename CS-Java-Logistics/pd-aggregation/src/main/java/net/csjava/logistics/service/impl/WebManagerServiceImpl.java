package net.csjava.logistics.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.csjava.logistics.DTO.DriverJobDTO;
import net.csjava.logistics.DTO.TaskPickupDispatchDTO;
import net.csjava.logistics.DTO.TaskTransportDTO;
import net.csjava.logistics.DTO.TransportOrderDTO;
import net.csjava.logistics.DTO.webManager.DriverJobQueryDTO;
import net.csjava.logistics.DTO.webManager.TaskPickupDispatchQueryDTO;
import net.csjava.logistics.DTO.webManager.TaskTransportQueryDTO;
import net.csjava.logistics.DTO.webManager.TransportOrderQueryDTO;
import net.csjava.logistics.common.utils.PageResponse;
import net.csjava.logistics.mapper.WebManagerMapper;
import net.csjava.logistics.service.WebManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebManagerServiceImpl implements WebManagerService {

    @Autowired
    private WebManagerMapper webManagerMapper;

    @Override
    public PageResponse<DriverJobDTO> findDriverJobByPage(DriverJobQueryDTO dto) {
        IPage<DriverJobDTO> iPage = new Page();
        iPage.setSize(dto.getPageSize());
        iPage.setCurrent(dto.getPage());
        webManagerMapper.findDriverJobByPage(iPage, dto);
        return PageResponse.<DriverJobDTO>builder()
                .counts(iPage.getTotal())
                .pages(iPage.getPages())
                .pagesize(dto.getPageSize())
                .page(dto.getPage())
                .items(iPage.getRecords())
                .build();
    }

    @Override
    public PageResponse<TaskPickupDispatchDTO> findTaskPickupDispatchJobByPage(TaskPickupDispatchQueryDTO dto) {
        IPage<TaskPickupDispatchDTO> iPage = new Page();
        iPage.setSize(dto.getPageSize());
        iPage.setCurrent(dto.getPage());
        webManagerMapper.findTaskPickupDispatchJobByPage(iPage, dto);
        return PageResponse.<TaskPickupDispatchDTO>builder()
                .counts(iPage.getTotal())
                .pages(iPage.getPages())
                .pagesize(dto.getPageSize())
                .page(dto.getPage())
                .items(iPage.getRecords())
                .build();
    }

    @Override
    public PageResponse<TransportOrderDTO> findTransportOrderByPage(TransportOrderQueryDTO dto) {
        IPage<TransportOrderDTO> iPage = new Page();
        iPage.setSize(dto.getPageSize());
        iPage.setCurrent(dto.getPage());
        webManagerMapper.findTransportOrderByPage(iPage, dto);
        return PageResponse.<TransportOrderDTO>builder()
                .counts(iPage.getTotal())
                .pages(iPage.getPages())
                .pagesize(dto.getPageSize())
                .page(dto.getPage())
                .items(iPage.getRecords())
                .build();
    }

    @Override
    public PageResponse<TaskTransportDTO> findTaskTransportByPage(TaskTransportQueryDTO dto) {
        IPage<TaskTransportDTO> iPage = new Page();
        iPage.setSize(dto.getPageSize());
        iPage.setCurrent(dto.getPage());
        webManagerMapper.findTaskTransportByPage(iPage, dto);
        return PageResponse.<TaskTransportDTO>builder()
                .counts(iPage.getTotal())
                .pages(iPage.getPages())
                .pagesize(dto.getPageSize())
                .page(dto.getPage())
                .items(iPage.getRecords())
                .build();
    }
}
