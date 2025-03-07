package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result getEmps(@RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(defaultValue = "10") Integer pageSize,
                          String name,
                          Short gender,
                          @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                          @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end
    ) {
        log.info("{},{},{},{},{},{}", page, pageSize, name, gender, begin, end);
        PageBean pageBean = empService.getPageBean(page, pageSize, name, gender, begin, end);

        return Result.success(pageBean);
    }

    @GetMapping("/{id}")
    public Result getEmpById(@PathVariable Integer id) {
        log.info("{}", id);

        Emp emp = empService.getEmpById(id);


        return Result.success(emp);
    }


    @PutMapping
    public Result updateEmp(@RequestBody Emp emp) {
        empService.updateEmp(emp);

        return Result.success();
    }



    @DeleteMapping("/{ids}")
    public Result deleteEmp(@PathVariable List<Integer> ids) {
        log.info("{}", ids);
        empService.deleteEmp(ids);
        return Result.success();
    }

    @PostMapping
    public Result addEmp(@RequestBody Emp emp) {

        empService.addEmp(emp);
        return Result.success();
    }

}
