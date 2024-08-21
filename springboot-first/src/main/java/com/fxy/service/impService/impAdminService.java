package com.fxy.service.impService;

import com.fxy.mapper.adminMapper;
import com.fxy.pojo.Admin;
import com.fxy.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class impAdminService implements adminService {
    @Autowired
    private adminMapper adminMapper;


    public String loginService(Admin admin) {
        if(adminMapper.login(admin)==null){
            return "用户名或者密码不存在";
        }
        else {
            System.out.println(adminMapper.login(admin));
            return "登录成功";
        }
    }
}
