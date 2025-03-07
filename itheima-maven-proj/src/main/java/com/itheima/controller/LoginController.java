package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.pojo.User;
import com.itheima.service.EmpService;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;


    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        Emp found = empService.login(emp);

        if (found != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", found.getId());
            claims.put("name", found.getName());
            claims.put("username", found.getUsername());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }


        return Result.error("username or password incorrect");

    }

}
