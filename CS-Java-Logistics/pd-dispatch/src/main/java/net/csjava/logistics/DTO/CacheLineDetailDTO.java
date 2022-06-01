package net.csjava.logistics.DTO;

import net.csjava.logistics.entity.CacheLineDetailEntity;


@Data
public class CacheLineDetailDTO extends CacheLineDetailEntity {

    /**
     * 起始机构
     */
    private String startAgency;

    /**
     * 终点机构
     */
    private String endAgency;

}
