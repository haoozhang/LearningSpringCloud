package com.zhao;

import com.zhao.config.CustomLoadBalancerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@LoadBalancerClients(defaultConfiguration = CustomLoadBalancerConfig.class)
public class DeptConsumer {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer.class, args);
    }
}
