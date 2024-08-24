package com.fxy.controller;

import com.fxy.pojo.Result;
import com.fxy.pojo.Admin;
import com.fxy.service.adminService;
import com.fxy.utils.jwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {
    @Autowired
    private adminService adminService;
    String jwtToken = null;

    @PostMapping("/login")
    public Result login(@RequestBody Admin admin) {
        int flag = adminService.loginService(admin);
        HashMap <String,Object> map = new HashMap();
        map.put("uesername",admin.getUsername());
        map.put("password",admin.getPassword());
        if(flag==1){
            jwtToken = jwtUtils.createJWT(map);
            return Result.success(jwtToken);
        }
        else
            return Result.error();
    }
}
