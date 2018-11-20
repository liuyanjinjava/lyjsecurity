package com.lyj.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @auther lyj
 * @date 2018/11/20 0020 上午 11:48
 */
@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.lyj.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("time aspect start");
        Object[] args=pjp.getArgs();
        for (Object ar:args){
            System.out.println("arg is"+args);
        }
        long start=new Date().getTime();
        Object object = pjp.proceed();
        System.out.println("time aspect 耗时"+(new Date().getTime()-start));
        System.out.println("time aspect end");
        return object;
    }

}
