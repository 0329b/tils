package com.tils.aop;

import com.alibaba.fastjson.JSONObject;
import com.tils.mapper.OperateLogMapper;
import com.tils.pojo.OperateLog;
import com.tils.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;

@Component
@Aspect
@Slf4j
public class LogAspect {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.tils.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {

        //操作人ID
        //获取jwt令牌并解析
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.paresJwt(jwt);
        Integer operateUser = (Integer) claims.get("id");
        //操作时间
        LocalDateTime operateTime = LocalDateTime.now();
        //操作方法类名
        String className = joinPoint.getClass().getName();
        //操作方法名
        String methodName = joinPoint.getSignature().getName();
        //方法参数
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);
        //调用原始方法
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        //方法返回值
        String returnValue = JSONObject.toJSONString(result);
        //操作耗时
        Long costTime = start - end;
        //记录操作日记
        OperateLog operateLog = new OperateLog(null,operateUser,operateTime,className,methodName,methodParams,returnValue,costTime);
        operateLogMapper.insert(operateLog);
        return result;
    }

}
