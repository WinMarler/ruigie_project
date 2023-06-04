package com.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * @description:
 * @author:WINmarler
 * @time2023/5/18 11:07
 */
@Slf4j
@Component
@Aspect
public class TimeAspect {
    @Around("execution(* com.example.service.impl.DeptServiceImpl.*(..))") //切入点表达式
    //@Around("com.itheima.aop.MyAspect1.pt()")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        //1. 记录开始时间
        long begin = System.currentTimeMillis();

        //2. 调用原始方法运行
        Object result = joinPoint.proceed();

        //3. 记录结束时间, 计算方法执行耗时
        long end = System.currentTimeMillis();
        log.info(joinPoint.getSignature()+"方法执行耗时: {}ms", end-begin);

        return result;
    }

}