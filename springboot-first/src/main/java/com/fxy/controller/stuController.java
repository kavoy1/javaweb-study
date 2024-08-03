package com.fxy.controller;

import com.fxy.pojo.Result;
import com.fxy.pojo.student;
import com.fxy.service.stuService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class stuController {
    @Autowired
    private stuService stuService;

    @GetMapping("/stus")
    public Result SearchAll() {
        List<student> stu = stuService.selectAll();
        return Result.success(stu);
    }

    @DeleteMapping("/stus/{id}")
    public Result DeleteById(@PathVariable int id) {
        stuService.deleteById(id);
        return Result.success();
    }

    @PostMapping("/stus")
    public Result Insert(@RequestBody student stu) {
        stuService.insert(stu);
        return Result.success();
    }
}
