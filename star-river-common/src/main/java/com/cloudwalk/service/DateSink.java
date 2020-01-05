package com.cloudwalk.service;

import org.springframework.stereotype.Service;

/**
 * 日历结构更新接口
 * @author yanggang
 * @date 2019-12-16
 * @since jdk 1.8
 * @version 1.0
 */
@Service
public interface DateSink {
    /**
     *
     * @param body
     * @return
     */
    String sink(String body);
}
