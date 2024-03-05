package com.tils.controller;

import com.tils.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.*;

@Slf4j
@RestController
public class SessionController {

    //设置Cookie
    //往HttpSession存储
    @GetMapping("/c1")
    public Result cookie1(HttpSession session) {
        session.setAttribute("", "");
        return Result.success();
    }
    //获取Cookie
    @GetMapping("/c2")
    public Result cookie2(HttpServletRequest request) {
//        Cookie[] cookies = request.getCookies();   //获得所有Cookie
//        for(Cookie cookie:cookies){
//            if(cookie.getName().equals("")){
//                System.out.println(""+cookie.getValue());
//            }
//        }
        HttpSession session = request.getSession();
        Object login = session.getAttribute("");
        return Result.success(login);
    }

}
