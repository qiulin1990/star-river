package com.cloudwalk.service.imp;


import com.cloudwalk.constant.Errors;
import com.cloudwalk.mapper.MDimDayMapper;
import com.cloudwalk.service.DateSink;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 日历结构更新服务
 *
 * @author yanggang
 * @version 1.0
 * @date 2019-12-16
 * @since jdk 1.8
 */
@Service
@Slf4j
public class DateSinkImp implements DateSink {
    @Autowired
    MDimDayMapper mDimDayMapper;

    /**
     * 日历结构更新方法，输入年例如
     *
     * @param body 2019
     * @return
     */
    @Override
    public String sink(String body) {
        String status = Errors.fromId(0).name;
        try {
            mDimDayMapper.callFMDimDay(body);
            log.info("status--{},body--{}", status, body);
            return status;
        } catch (Exception e) {
            log.error("exception--{},body--{}", e.getStackTrace(), body);
            status = Errors.fromId(3).name;
            return status;
        }
    }
}
