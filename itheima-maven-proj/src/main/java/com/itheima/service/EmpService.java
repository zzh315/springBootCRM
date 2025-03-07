package com.itheima.service;


import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    PageBean getPageBean(Integer pageNo, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void deleteEmp(List<Integer> ids);

   void addEmp(Emp emp) ;

    Emp getEmpById(Integer id);

    void updateEmp(Emp emp);

    Emp login(Emp emp);
}
