package com.tils.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class TimeAspect {
    @Around("execution(* com.tils.service.*.*(..))")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        //记录时间
        long begin = System.currentTimeMillis();
        //调用原始方法
        Object result = joinPoint.proceed();
        //记录结束时间，计算执行耗时
        long end = System.currentTimeMillis();
        log.info(joinPoint.getSignature()+"方法耗时：{}ms",end-begin);
        return result;
    }

}
