package com.zhao.service;

import com.zhao.pojo.Dept;

import java.util.List;

public interface DeptService {

    boolean addDept(Dept dept);

    Dept selectDeptById(Long id);

    List<Dept> selectAllDept();

}
