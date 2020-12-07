package com.xiaoleng.datasource01.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author chen jia
 * @date 2020/12/4 14:48
 */

@Component
public class ManageCenter {

    @Autowired
    @Qualifier("slave1Datasource")
    private DataSource slave1Datasource;

    @Autowired
    @Qualifier("masterDatasource")
    private DataSource masterDatasource;


    public DataSource getSlaveDatasource() {
        return slave1Datasource;
    }

    public DataSource getMaterDatasource() {
        return masterDatasource;
    }
}
