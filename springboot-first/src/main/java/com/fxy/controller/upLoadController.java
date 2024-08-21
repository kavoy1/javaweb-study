package com.fxy.controller;

import com.fxy.pojo.Result;
import com.fxy.utils.AliOssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class upLoadController {
    @Autowired
    AliOssUtil ossUtil;
    @PostMapping("/upload")
    public Result upload(@RequestParam("image") MultipartFile image) throws Exception {

        String url = ossUtil.upload(image);
        return  Result.success(url);
    }
}
