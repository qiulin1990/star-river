package com.cloudwalk.control;


import com.cloudwalk.constant.Errors;
import com.cloudwalk.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
@RequestMapping("/data")
public class DataController {
    @Autowired
    RestTemplate restTemplate;

    /**
     * @param id
     * @param httpServletRequest
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, String> call(@PathVariable("id") String id, HttpServletRequest httpServletRequest) throws IOException {

        Map<String, String> res = new HashMap<>();
        String status;
        try {

            status = restTemplate.getForObject("http://STAR-RIVER-COMMON/date/call/" + id, String.class);
            res.put("id", id);
            res.put("status", status);
            res.put("time", DateUtils.getCurrentTime());
            log.info("id--{}", id);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("error--{},year--{},exception--{}", Errors.fromId(1), id, e.getStackTrace());
        }
        return res;
    }
}
