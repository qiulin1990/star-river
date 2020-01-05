package com.cloudwalk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class StarRiverDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarRiverDataApplication.class, args);
    }

}
