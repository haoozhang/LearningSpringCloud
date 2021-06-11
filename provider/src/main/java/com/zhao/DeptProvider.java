package com.zhao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  // 开启 Eureka 客户端，自动注册该服务到 Eureka Server
public class DeptProvider {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider.class, args);
    }
}
