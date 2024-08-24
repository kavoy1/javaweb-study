package com.fxy.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;

public class jwtUtils {
    private static final String signKey ="asdasadasdasddddddddddddddddddddaaaaaaaaaaaaaaasssssssssssssss";
    private static Long expire = 430000L;

    public static String createJWT(HashMap<String, Object> map) {
        String jwt = Jwts.builder()
                .addClaims(map)
                .signWith(SignatureAlgorithm.HS256, signKey)
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .compact();
        return jwt;
    }

    public static Claims parseJWT(String jwt) {
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt).getBody();
        return claims;
    }
}
