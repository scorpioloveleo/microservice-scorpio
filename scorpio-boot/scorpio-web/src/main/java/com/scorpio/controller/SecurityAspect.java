package com.scorpio.controller;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class SecurityAspect {

    /**
     * 定义切点
     */
//    @Pointcut("execution(public * com.transsnet.*.web.controller.*.*(..))") //启动慢
    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void privilege(){}

    /**
     * 权限环绕通知
     * @param joinPoint
     * @throws Throwable
     */
    @Around("privilege()")
    public Object isAccessMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("======================Around-----------------------");
        //throw new ApplicationException(SysError.NO_PERMISSION);
        return joinPoint.proceed();
    }


}
