package com.fxy.controller;

import com.fxy.pojo.Result;
import com.fxy.pojo.student;
import com.fxy.service.stuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class stuController {
    @Autowired
    private stuService stuService;

    @GetMapping("/stus")
    public Result searchAll() {
        List<student> stu = stuService.selectAll();
        return Result.success(stu);
    }
}
