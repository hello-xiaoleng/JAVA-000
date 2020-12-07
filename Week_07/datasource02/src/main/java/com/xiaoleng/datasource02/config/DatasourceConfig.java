package com.xiaoleng.datasource02.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author chenjia
 * @date 2020/12/07
 */
@Configuration
public class DatasourceConfig {

    @Value("${spring.datasource.master.url}")
    private String masterUrl;

    @Value("${spring.datasource.master.username}")
    private String masterUsername;

    @Value("${spring.datasource.master.password}")
    private String masterPassword;

    @Value("${spring.datasource.master.driver-class-name}")
    private String masterDriverClassName;

    @Value("${spring.datasource.slave1.url}")
    private String slave1Url;

    @Value("${spring.datasource.slave1.username}")
    private String slave1Username;

    @Value("${spring.datasource.slave1.password}")
    private String slave1Password;

    @Value("${spring.datasource.slave1.driver-class-name}")
    private String slave1DriverClassName;


    @Bean
    public DataSource masterDatasource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        Properties properties = new Properties();
        properties.put("druid.username", masterUsername);
        properties.put("druid.url", masterUrl);
        properties.put("druid.password", masterPassword);
        properties.put("druid.driverClassName", masterDriverClassName);
        druidDataSource.configFromPropety(properties);
        return druidDataSource;
    }

    @Bean
    public DataSource slave1Datasource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        Properties properties = new Properties();
        properties.put("druid.username", slave1Username);
        properties.put("druid.url", slave1Url);
        properties.put("druid.password", slave1Password);
        properties.put("druid.driverClassName", slave1DriverClassName);
        druidDataSource.configFromPropety(properties);
        return druidDataSource;
    }

    @Bean
    @Primary
    public DynamicDatasource multipleDataSourceToChoose(@Qualifier("masterDatasource") DataSource master,
                                                        @Qualifier("slave1Datasource") DataSource slave1) {

        DynamicDatasource dynamicDatasource = new DynamicDatasource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("master", master);
        targetDataSources.put("slave1", slave1);
        //设置数据源映射
        dynamicDatasource.setTargetDataSources(targetDataSources);
        //设置默认数据源，当无法映射到数据源时会使用默认数据源
        dynamicDatasource.setDefaultTargetDataSource(master);
        dynamicDatasource.afterPropertiesSet();
        return dynamicDatasource;
    }


}
