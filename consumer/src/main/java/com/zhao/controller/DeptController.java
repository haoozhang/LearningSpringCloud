package com.zhao.controller;

import com.zhao.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController {

    // 消费者不应有 Service 层，那么如何调用提供者的服务呢？Spring 支持 RestFul 风格
    // Spring Cloud 中抛弃 Dubbo 的 RPC 通信，基于 Http 的 REST API 通信
    // RestTemplate 是 RestFul 服务的模板，用于访问远程 Http 服务器
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient client;

    private static String REST_URL_PREFIX = "http://localhost:8081";

    @GetMapping("/dept/get/{id}")
    public Dept getDept(@PathVariable("id") Long id) {
        // 根据提供者名称获取服务的访问路径
        //REST_URL_PREFIX = client.getInstances("provider").get(0).getUri().toString();
        REST_URL_PREFIX = "http://provider";
        System.out.println("REST_URL_PREFIX ==> " + REST_URL_PREFIX);
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
    }

    @GetMapping("/dept/get")
    public List<Dept> getAllDept() {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get", List.class);
    }

    @RequestMapping("/dept/add")
    public boolean addDept(Dept dept) {
        Assert.notNull(dept, "dept must not be null!");
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
    }

    @GetMapping("/svcInfo")
    public String serviceInfo() {
        List<ServiceInstance> instances = client.getInstances("provider");
        return instances.toString();
    }

}
