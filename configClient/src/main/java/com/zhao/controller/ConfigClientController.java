package com.zhao.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

    @Value("${spring.application.name}")
    private String appName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer;

    @Value("${server.port}")
    private String port;

    @GetMapping("/getConfig")
    public String getConfig() {
        return "appName: " + appName +
               "\neurekaServer: " + eurekaServer +
               "\nport: " + port;
    }
}
