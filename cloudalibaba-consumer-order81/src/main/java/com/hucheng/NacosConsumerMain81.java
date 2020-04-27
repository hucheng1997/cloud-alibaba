package com.hucheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author HuChan
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumerMain81 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerMain81.class, args);
    }
}
