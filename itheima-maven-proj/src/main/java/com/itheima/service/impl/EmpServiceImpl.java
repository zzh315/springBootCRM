package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.User;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean getPageBean(Integer pageNo, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        PageHelper.startPage(pageNo, pageSize);

        List<Emp> emps = empMapper.getEmps(name, gender, begin, end);
        Page<Emp> page = (Page<Emp>) emps;

        return new PageBean(page.getTotal(), page.getResult());
    }

    @Override
    public void deleteEmp(List<Integer> ids) {
        empMapper.deleteEmp(ids);
    }

    @Override
    public void addEmp(Emp emp) {
        empMapper.addEmp(emp);
    }

    @Override
    public Emp getEmpById(Integer id) {
        return empMapper.getEmpById(id);
    }

    @Override
    public void updateEmp(Emp emp) {
        empMapper.updateEmp(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.getByUserNameAndPassword(emp);
    }
}
