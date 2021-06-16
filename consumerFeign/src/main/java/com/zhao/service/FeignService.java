package com.zhao.service;

import com.zhao.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "PROVIDER")
public interface FeignService {

    @PostMapping("/dept/add")
    boolean addDept(Dept dept);

    @GetMapping("/dept/get/{id}")
    Dept selectDeptById(@PathVariable("id") Long id);

    @GetMapping("/dept/get")
    List<Dept> selectAllDept();
}
