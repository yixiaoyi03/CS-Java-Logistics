package net.csjava.logistics.DTO;


import lombok.Data;
import net.csjava.logistics.entity.CacheLineDetailEntity;

@Data
public class OrderLineDTO {

    private CacheLineDetailEntity cacheLineDetailEntity;

    private OrderClassifyGroupDTO orderClassifyGroupDTO;

    public OrderLineDTO(CacheLineDetailEntity cacheLineDetailEntity,OrderClassifyGroupDTO orderClassifyGroupDTO) {
        this.cacheLineDetailEntity = cacheLineDetailEntity;
        this.orderClassifyGroupDTO = orderClassifyGroupDTO;
    }
}
