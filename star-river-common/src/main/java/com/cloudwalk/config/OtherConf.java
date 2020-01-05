package com.cloudwalk.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Configuration
@ConfigurationProperties(prefix = "otherConfig")
@Component
/**
 * 配置信息获取对象
 *
 * @author yanggang
 * @version 1.0
 * @date 2019-11-11
 * @since jdk 1.8
 */
public class OtherConf {
    private String kafkaProducerBootstrapServers;
    private String kafkaProducerTopicName;
}
