package com.itheima.controller;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    DeptService deptService;


    @GetMapping
    public Result list() {

        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id) {
        deptService.delete(id);

        return Result.success("deleted successfully");
    }

    @PostMapping
    public Result add(@RequestBody Dept dept) {
        deptService.add(dept);
        return Result.success();
    }
}
