package com.fxy;

import com.fxy.mapper.adminMapper;
import com.fxy.utils.AliOssProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootFirstApplicationTests {

    @Autowired
    private AliOssProperties aliOssProperties;
@Autowired
    private adminMapper adminMapper;
    @Test
    void contextLoads() {
        System.out.println(adminMapper.se());
    }



}
