package net.csjava.logistics.future;


import net.csjava.logistics.DTO.OrderDTO;
import net.csjava.logistics.DTO.TransportOrderDTO;
import net.csjava.logistics.feign.OrderFeign;
import net.csjava.logistics.feign.TransportOrderFeign;

import java.awt.geom.Area;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class PdCompletableFuture {


    public static final CompletableFuture<Map<Long, Area>> areaMapFuture(AreaApi api, Long parentId, Set<Long> areaSet) {
        R<List<Area>> result = api.findAll(parentId, new ArrayList<>(areaSet));
        return CompletableFuture.supplyAsync(() ->
                result.getData().stream().collect(Collectors.toMap(Area::getId, vo -> vo)));
    }

    /**
     * 获取机构数据列表
     *
     * @param api        数据接口
     * @param agencyType 机构类型
     * @param ids        机构id列表
     * @return 执行结果
     */
    public static final CompletableFuture<Map<Long, Org>> agencyMapFuture(OrgApi api, Integer agencyType, Set<String> ids, Long countyId) {
        return CompletableFuture.supplyAsync(() -> {
            R<List<Org>> result = api.list(agencyType, ids.stream().mapToLong(id -> Long.valueOf(id)).boxed().collect(Collectors.toList()), countyId, null, null);
            if (result.getIsSuccess()) {
                return result.getData().stream().collect(Collectors.toMap(Org::getId, org -> org));
            }
            return new HashMap<>();
        });
    }

    /**
     * 批量获取订单信息
     *
     * @param api
     * @param orderSet
     * @return
     */
    public static CompletableFuture<Map<String, OrderDTO>> orderMapFuture(OrderFeign api, Set<String> orderSet) {
        return CompletableFuture.supplyAsync(() -> {
            List<OrderDTO> result = api.findByIds(orderSet.stream().collect(Collectors.toList()));
            return result.stream().collect(Collectors.toMap(OrderDTO::getId, item -> item));
        });
    }

    /**
     * 批量获取运单信息
     *
     * @param api
     * @param orderSet
     * @return
     */
    public static CompletableFuture<Map<String, TransportOrderDTO>> tranOrderMapFuture(TransportOrderFeign api, Set<String> orderSet) {
        return CompletableFuture.supplyAsync(() -> {
            List<TransportOrderDTO> result = api.findByOrderIds(orderSet.stream().collect(Collectors.toList()));
            return result.stream().collect(Collectors.toMap(TransportOrderDTO::getOrderId, item -> item, (v1, v2) -> v1));
        });
    }
}
