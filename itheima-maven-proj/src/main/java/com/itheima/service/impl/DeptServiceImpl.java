package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Emp;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptMapper deptMapper;
    @Autowired
    EmpMapper empMapper;


    @Override
    public List<Dept> list() {


        return deptMapper.list();
    }

    @Transactional
    @Override
    public void delete(int id) {
        deptMapper.delete(id);
        empMapper.deleteByDeptId(id);
    }

    @Override
    public void add(Dept dept) {
        deptMapper.add(dept);
    }
}
