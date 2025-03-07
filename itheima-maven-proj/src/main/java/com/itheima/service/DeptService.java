package com.itheima.service;

import com.itheima.pojo.Dept;
import java.util.List;


public interface DeptService {

    List<Dept> list();

    void delete(int id);

    void add(Dept dept);
}
