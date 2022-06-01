package net.csjava.logistics.utils;

import com.itheima.pinda.common.utils.IdWorker;

public class IdUtils {
    private static final IdWorker ID_WORKER = new IdWorker();

    public static String get() {
        return String.valueOf(ID_WORKER.nextId());
    }
}
