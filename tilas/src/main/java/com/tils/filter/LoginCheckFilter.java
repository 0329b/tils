package com.tils.filter;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.util.StringUtil;
import com.tils.pojo.Result;
import com.tils.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        HttpServletResponse resp=(HttpServletResponse) servletResponse;
        //1.获取url
        String url = req.getRequestURI().toString();
        //2.判断url是否含有login，有就是登陆操作，放行
         if(url.contains("login")){
             log.info("登陆操作，放行");
             filterChain.doFilter(servletRequest,servletResponse);
             return;
         }
        //3.获取head头部令牌
        String jwt = req.getHeader("token");
        //4.判断令牌是否存在，不存在就返回错误信息，没有登陆
         if(!StringUtils.hasLength(jwt)){
             Result error = Result.error("NOT_LOGIN");
             //手动转换json
             String jsonString = JSONObject.toJSONString(error);
              resp.getWriter().write(jsonString);
              return;
         }
        //5.解析令牌，如果解析失败，就返回没有登录
        try {
            JwtUtils.paresJwt(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败");
            Result error = Result.error("NOT_LOGIN");
            //手动转换json
            String jsonString = JSONObject.toJSONString(error);
            resp.getWriter().write(jsonString);
            return;
        }
        //6.放行
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
