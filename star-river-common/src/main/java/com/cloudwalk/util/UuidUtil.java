package com.cloudwalk.util;

import java.util.UUID;

/**
 * uuid工具类
 *
 * @author yanggang
 * @version 1.0
 * @date 2019-11-11
 * @since jdk 1.8
 */
public class UuidUtil {
    /**
     * @return
     */
    public static String getUUID32() {
        String uuid = UUID.randomUUID().toString().replace("-", "")
                .toLowerCase();
        return uuid;
    }
}
