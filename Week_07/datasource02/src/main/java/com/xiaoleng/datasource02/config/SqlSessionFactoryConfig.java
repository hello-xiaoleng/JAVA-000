package com.xiaoleng.datasource02.config;


import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import java.io.IOException;

@Configuration
@MapperScan(basePackages = {"com.xiaoleng.datasource02.mapper"}, sqlSessionFactoryRef = "sqlSessionFactory")
public class SqlSessionFactoryConfig {

    @Resource
    private DynamicDatasource dynamicDatasource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setDataSource(dynamicDatasource);
        // 扫描相关mapper文件
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String sqlXmlPath = "classpath*:sqlMapper/*.xml";
        try {
            factoryBean.setMapperLocations(resolver.getResources(sqlXmlPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            sqlSessionFactory = factoryBean.getObject();
            sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            factoryBean.afterPropertiesSet();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }

}
