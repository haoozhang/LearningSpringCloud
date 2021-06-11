package com.zhao.mapper;

import com.zhao.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {

    boolean addDept(Dept dept);

    Dept selectDeptById(Long id);

    List<Dept> selectAllDept();
}
