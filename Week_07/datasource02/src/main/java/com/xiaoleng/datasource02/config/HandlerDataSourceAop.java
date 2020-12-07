package com.xiaoleng.datasource02.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

@Slf4j
@Component
@Aspect
public class HandlerDataSourceAop {

    @Resource
    private DatasourceManageCenter datasourceManageCenter;

    @Pointcut("@within(com.xiaoleng.datasource02.config.Read)||@annotation(com.xiaoleng.datasource02.config.Read)")
    public void readPointCut() {
    }

    @Pointcut("@annotation(com.xiaoleng.datasource02.config.Write)||@annotation(com.xiaoleng.datasource02.config.Write)")
    public void writePointCut() {
    }

    @Before("readPointCut()")
    public void doReadBefore(JoinPoint joinPoint) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        String slaveDatasourceKey = datasourceManageCenter.getSlaveDatasourceKey();
        HandlerDataSource.setDataSource(slaveDatasourceKey);
        log.info("dynamicDatasource,dataSourceKey:" + slaveDatasourceKey);
    }

    @After("readPointCut()")
    public void doReadAfter(JoinPoint joinPoint) {
        HandlerDataSource.clear();
    }

    @Before("writePointCut()")
    public void doWriteBefore(JoinPoint joinPoint) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        String materDatasourceKey = datasourceManageCenter.getMaterDatasourceKey();
        HandlerDataSource.setDataSource(materDatasourceKey);
        log.info("dynamicDatasource,dataSourceKey:" + materDatasourceKey);
    }

    @After("writePointCut()")
    public void doWriteAfter(JoinPoint joinPoint) {
        HandlerDataSource.clear();
    }

}
