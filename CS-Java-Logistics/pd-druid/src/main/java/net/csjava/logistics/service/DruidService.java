package net.csjava.logistics.service;

import net.csjava.logistics.common.utils.Result;

import java.util.List;
import java.util.Map;

public interface DruidService {

    Result queryAllTruckLast(Map<String, Object> params);

    Result queryOneTruck(Map<String, Object> params);

    Result queryAll(List<Map<String, Object>> params);
}
