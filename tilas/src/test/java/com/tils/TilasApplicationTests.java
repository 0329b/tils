package com.tils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TilasApplicationTests {

    @Test
    void contextLoads() {

        Map<String, Object> claims=new HashMap<>();
        claims.put("id",1);
        claims.put("name","tom");
        String tils = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "tils")    //设置算法
                .setClaims(claims)   //增加载荷
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))  //令牌有效时间
                .compact();  //生成令牌
        System.out.println(tils);
    }

}
