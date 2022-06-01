package net.csjava.logistics.DTO;

import lombok.Data;
import net.csjava.logistics.entity.OrderClassifyEntity;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class OrderClassifyLogDTO extends OrderClassifyEntity {

    /**
     * 起始机构
     */
    private String startAgency;

    /**
     * 终点机构
     */
    private String endAgency;

    /**
     * 线路
     */
    private CacheLineDTO cacheLineDTO;

    /**
     * 路线
     */
    private Set<String> lineSet = new LinkedHashSet<>();

    private Set<String> transportLineSet = new LinkedHashSet<>();

    private Set<String> tripsSet;
    private Set<String> truckSet;
    private Set<String> driverSet;
}
