package com.cloudwalk.control;



import com.cloudwalk.constant.Errors;
import com.cloudwalk.service.DateSink;
import com.cloudwalk.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 日期更新控制类
 *
 * @author yanggang
 * @version 1.0
 * @date 2019-11-16
 * @since jdk 1.8
 */
@Slf4j
@RestController
@RequestMapping("/date")
public class DateSinkController {
    @Autowired
    DateSink dateSink;

    /**
     *
     * @param year
     * @param httpServletRequest
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/call/{year}", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, String> call(@PathVariable("year") String year, HttpServletRequest httpServletRequest) throws IOException {
        Map<String, String> res = new HashMap<>();
        String status;
        try {
            status=dateSink.sink(year);
            res.put("year", year);
            res.put("status",status);
            res.put("time", DateUtils.getCurrentTime());
            log.info("res--{}",res);

        } catch (Exception e) {
            log.error("error--{},year--{},exception--{}", Errors.fromId(1), year, e.getStackTrace());
        }
        return res;
    }
}
