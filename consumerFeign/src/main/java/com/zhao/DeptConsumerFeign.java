package com.zhao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients  // 开启扫描 Feign 接口
public class DeptConsumerFeign {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerFeign.class, args);
    }
}
