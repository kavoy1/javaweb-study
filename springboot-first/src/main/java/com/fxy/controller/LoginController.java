package com.fxy.controller;

import com.fxy.pojo.Result;
import com.fxy.pojo.Admin;
import com.fxy.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private adminService adminService;


    @PostMapping("/login")
    public Result login(@RequestBody Admin admin) {
        String s = adminService.loginService(admin);
        return Result.success(s);
    }
}
