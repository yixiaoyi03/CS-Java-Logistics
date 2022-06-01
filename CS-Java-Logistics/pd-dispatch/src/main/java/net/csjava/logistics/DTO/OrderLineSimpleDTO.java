package net.csjava.logistics.DTO;
import net.csjava.logistics.entity.CacheLineDetailEntity;
import java.util.List;

@Data
public class OrderLineSimpleDTO {

    private CacheLineDetailEntity cacheLineDetailEntity;

    private List<OrderClassifyGroupDTO> orderClassifyGroupDTOS;

    public OrderLineSimpleDTO(CacheLineDetailEntity cacheLineDetailEntity, List<OrderClassifyGroupDTO> orderClassifyGroupDTOS) {
        this.cacheLineDetailEntity = cacheLineDetailEntity;
        this.orderClassifyGroupDTOS = orderClassifyGroupDTOS;
    }
}
