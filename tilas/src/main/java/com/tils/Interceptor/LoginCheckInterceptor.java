package com.tils.Interceptor;

import com.alibaba.fastjson.JSONObject;
import com.tils.pojo.Result;
import com.tils.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        //1.获取url
        String url = req.getRequestURI().toString();
        //2.判断url是否含有login，有就是登陆操作，放行
        if(url.contains("login")){
            log.info("登陆操作，放行");
            return true;
        }
        //3.获取head头部令牌
        String jwt = req.getHeader("token");
        //4.判断令牌是否存在，不存在就返回错误信息，没有登陆
        if(!StringUtils.hasLength(jwt)){
            Result error = Result.error("NOT_LOGIN");
            //手动转换json
            String jsonString = JSONObject.toJSONString(error);
            resp.getWriter().write(jsonString);
            return false;
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
            return false;
        }
        //6.放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
