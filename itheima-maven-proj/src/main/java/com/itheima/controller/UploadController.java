package com.itheima.controller;


import com.aliyun.oss.AliOSSUtils;
import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;


@Slf4j
@RestController
public class UploadController {
    @Autowired
    private AliOSSUtils ossUtils;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {

        String url = ossUtils.upload(image);

        return Result.success(url);
    }
}
