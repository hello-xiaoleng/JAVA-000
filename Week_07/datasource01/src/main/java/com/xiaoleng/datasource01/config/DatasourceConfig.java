package com.xiaoleng.datasource01.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author chen jia
 * @date 2020/12/3 17:29
 */

@Component
public class DatasourceConfig {

    @Autowired
    @Qualifier("master")
    private DatasourceDto master;

    @Autowired
    @Qualifier("slave1")
    private DatasourceDto slave1;


    @Bean
    public DataSource masterDatasource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.configFromPropety(convert(master));
        return druidDataSource;
    }

    @Bean
    public DataSource slave1Datasource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.configFromPropety(convert(slave1));
        return druidDataSource;
    }

    private Properties convert(DatasourceDto datasourceDto) {
        Properties properties = new Properties();
        properties.put("druid.username", datasourceDto.getUserName());
        properties.put("druid.url", datasourceDto.getUrl());
        properties.put("druid.password", datasourceDto.getPassword());
        properties.put("druid.driverClassName", datasourceDto.getDriverClassName());
        return properties;

    }


}
