package com.itheima.exception;

import com.itheima.pojo.Result;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result ex(Exception e) {
        return Result.error(e.getMessage());
    }
}
