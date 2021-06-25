package com.zhao.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // 增加 path 匹配，以 /customize/dept/** 开头的请求都在此路由
                .route(r -> r.path("/customize/dept/**")
                        // 跳过第一个前缀，剩下的路径与 uri 拼接
                        .filters(f -> f.stripPrefix(1)
                                // 添加响应首部
                                .addResponseHeader("extendTag", "gateway-" + System.currentTimeMillis()))
                        // 指定匹配服务 provider，lb 是 load balance 的意思
                        .uri("lb://PROVIDER"))
                .build();
    }
}
