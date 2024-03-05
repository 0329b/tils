package com.tils.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {

    private static  String signKey="tils";
    private static  Long expire=43200000L;
    /**
     * 生成JWT令牌
     */
    public static String generateJwt(Map<String,Object> claims){
        String tils = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, signKey)    //设置算法
                .setClaims(claims)   //增加载荷
                .setExpiration(new Date(System.currentTimeMillis() +expire))  //令牌有效时间
                .compact();  //生成令牌
        return tils;
    }

    /**
     * 解释令牌
     */
    public static Claims paresJwt(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }

}
