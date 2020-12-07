package com.xiaoleng.datasource01.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chen jia
 * @date 2020/12/4 14:20
 */
@Component
@Aspect
public class ReadAspect {


    @Autowired
    private ManageCenter manageCenter;


    @Pointcut("@annotation(com.xiaoleng.datasource01.config.Read)")
    public void read() {

    }

    @Pointcut("@annotation(com.xiaoleng.datasource01.config.Write)")
    public void write() {

    }


    @Around("read()")
    public Object aroundRead(ProceedingJoinPoint point) throws Throwable {
        System.out.println("------begin-----");
        Object[] args = point.getArgs();
        args[0] = manageCenter.getSlaveDatasource();
        Object proceed = point.proceed(args);
        System.out.println("------end-----");
        return proceed;
    }

    @Around("write()")
    public Object aroundWrite(ProceedingJoinPoint point) throws Throwable {
        System.out.println("------begin-----");
        Object[] args = point.getArgs();
        args[0] = manageCenter.getMaterDatasource();
        Object proceed = point.proceed(args);
        System.out.println("------end-----");
        return proceed;
    }

}
