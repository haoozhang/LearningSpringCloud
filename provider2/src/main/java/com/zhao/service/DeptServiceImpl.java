package com.zhao.service;

import com.zhao.mapper.DeptMapper;
import com.zhao.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public boolean addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public Dept selectDeptById(Long id) {
        return deptMapper.selectDeptById(id);
    }

    @Override
    public List<Dept> selectAllDept() {
        return deptMapper.selectAllDept();
    }

}
