package com.zhao.controller;

import com.zhao.pojo.Dept;
import com.zhao.service.FeignService;
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

    @Autowired
    private FeignService feignService;

    @GetMapping("/dept/get/{id}")
    public Dept getDept(@PathVariable("id") Long id) {
        return feignService.selectDeptById(id);
    }

    @GetMapping("/dept/get")
    public List<Dept> getAllDept() {
        return feignService.selectAllDept();
    }

    @RequestMapping("/dept/add")
    public boolean addDept(Dept dept) {
        return feignService.addDept(dept);
    }
}
