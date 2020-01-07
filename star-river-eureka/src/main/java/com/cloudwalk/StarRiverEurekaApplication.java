package com.cloudwalk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class StarRiverEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarRiverEurekaApplication.class, args);
    }

}
