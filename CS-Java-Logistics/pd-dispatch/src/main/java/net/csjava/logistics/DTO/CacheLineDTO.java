package net.csjava.logistics.DTO;

import lombok.Data;
import net.csjava.logistics.entity.CacheLineEntity;

import java.util.List;

@Data
public class CacheLineDTO extends CacheLineEntity {

    private List<CacheLineDetailDTO> cacheLineDetailDTOS;

}
