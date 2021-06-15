package com.zhao.controller;


import com.zhao.pojo.Dept;
import com.zhao.service.DeptService;
import com.zhao.service.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept getDept(@PathVariable("id") Long id) {
        return deptService.selectDeptById(id);
    }

    @GetMapping("/dept/get")
    public List<Dept> getAllDept() {
        return deptService.selectAllDept();
    }

}
