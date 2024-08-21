package com.fxy.controller;

import com.fxy.pojo.Result;
import com.fxy.pojo.pageMsg;
import com.fxy.pojo.student;
import com.fxy.service.stuService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

    @GetMapping("/stus/{id}")
    public Result SearchById(@PathVariable int id) {
        student stu = stuService.selectById(id);
        return Result.success(stu);
    }

    @PutMapping("/stusUp")
    public Result UpdateById(@RequestBody student stu) {
        stuService.update(stu);
        return Result.success();
    }

    @PostMapping("/pageSrc")
    public Result pageSearch(@RequestBody pageMsg pageMsg) {
        System.out.println(pageMsg.getStu());
        List<student> ls = stuService.pageSrc(pageMsg);
        return Result.success(ls);
    }

    @DeleteMapping("/stusAllDel")
    public Result deleteById(@RequestBody List<Integer> id) {

        stuService.delAll(id);
        return Result.success();
    }

//    @PostMapping("/upload")
//    public Result addFile(@RequestParam("file") MultipartFile file) throws Exception {
//        String fileName = file.getOriginalFilename();
//
//        int i = fileName.lastIndexOf(".");
//        String suffix = fileName.substring(i);
//
//        String UUID = java.util.UUID.randomUUID().toString();
//
//        String fullName = UUID + suffix;
//
//        file.transferTo(new File("E:\\project\\java\\javaweb-study\\springboot-first\\src\\main\\resources\\FIles\\"+fullName));
//        return Result.success(fullName);
//    }


}
