package com.tils.controller;

import com.tils.pojo.Emp;
import com.tils.pojo.Result;
import com.tils.service.EmpService;
import com.tils.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("员工登录");
        Emp e = empService.login(emp);
        //判断是否登录成功，成功发放令牌
        if (e!=null){
            Map<String, Object> claims=new HashMap<>();
            claims.put("id",e.getId());
            claims.put("name",e.getName());
            claims.put("username",e.getUsername());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
            //失败返回错误数据
         return Result.error("登录失败");
    }
}
