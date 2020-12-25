package com.timebird.scheduleGetData.Connector;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectJConfig {
    @Before("execution (* com.timebird.scheduleGetData.Controller.*(..))")
    public void before(JoinPoint joinPoint){
        System.out.println(joinPoint.getThis().getClass().getName());
        System.out.println(joinPoint.getKind());
        System.out.println(joinPoint.getTarget().getClass().getName());
    }
}
