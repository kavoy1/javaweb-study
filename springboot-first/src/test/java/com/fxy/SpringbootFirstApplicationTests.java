package com.fxy;

import com.fxy.mapper.adminMapper;
import com.fxy.utils.AliOssProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;

@SpringBootTest
class SpringbootFirstApplicationTests {

    @Autowired
    private AliOssProperties aliOssProperties;
    @Autowired
    private adminMapper adminMapper;

    @Test
    void contextLoads() {
        String s = Keys.secretKeyFor(SignatureAlgorithm.HS256).toString();
        System.out.println(s);
    }

    /*
    生成JWT
     */
    @Test
    void JWTtest() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", 1);
        map.put("password", "123456");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "fxyfxyxxxxxxxxxxxxxxxyyyyyyxyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyxxxxxx".getBytes())//签名算法
                .setClaims(map)//自定义负载
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//过期时间
                .compact();//返回字符串
        System.out.println("JWT:");
        System.out.println(jwt);

        //解析
        String secretKey = "fxyfxyxxxxxxxxxxxxxxxyyyyyyxyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyxxxxxx";
        // 使用 Jwts.parser() 来创建 JwtParserBuilder 实例
        // 然后调用 setSigningKey 来设置签名密钥
        // 最后调用 parseClaimsJws 来解析 JWT 字符串
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey.getBytes()) // 将字符串转换为字节数组
                .parseClaimsJws(jwt)
                .getBody(); // 获取 JWT 中的声明

        // 打印 Claims 对象
        System.out.println("CLAIMS:");
        System.out.println(claims);
    }

    /*
    JWT解析
     */
//    @Test
//    void JWTTest() {
//        // 密钥，实际使用时应确保密钥的安全性
//        String secretKey = "fxyfxyxxxxxxxxxxxxxxxyyyyyyxyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyxxxxxx";
//        String s = "eyJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6IjEyMzQ1NiIsInVzZXJuYW1lIjoxLCJleHAiOjE3MjM3MDM5NTZ9.qsTPnfpf1kP-gp3uvi1xFA6HWsDMJ3TgKCttpVGzQSU";
//        // 使用 Jwts.parser() 来创建 JwtParserBuilder 实例
//        // 然后调用 setSigningKey 来设置签名密钥
//        // 最后调用 parseClaimsJws 来解析 JWT 字符串
//        Claims claims = Jwts.parser()
//                .setSigningKey(secretKey.getBytes()) // 将字符串转换为字节数组
//                .parseClaimsJws(s)
//                .getBody(); // 获取 JWT 中的声明
//
//        // 打印 Claims 对象
//        System.out.println(claims);
//    }
}

