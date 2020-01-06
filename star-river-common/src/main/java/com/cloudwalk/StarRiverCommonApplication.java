package com.cloudwalk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 工程main方法主入口
 *
 * @author yanggang
 * @version jdk 1.8
 * @date 2018/09/28 20:29 -
 * @since 1.0
 */
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class StarRiverCommonApplication {
    /**
     * 工程主方法
     *
     * @param args 工程启动入参
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(StarRiverCommonApplication.class, args);
    }
}
