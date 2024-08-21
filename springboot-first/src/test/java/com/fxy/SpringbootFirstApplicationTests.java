package com.fxy;

import com.fxy.utils.AliOssProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootFirstApplicationTests {

    @Autowired
    private AliOssProperties aliOssProperties;
    @Test
    void contextLoads() {
        System.out.println(aliOssProperties.getAccessKeyId());
    }

}
