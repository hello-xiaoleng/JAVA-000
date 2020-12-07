package com.xiaoleng.datasource02.config;

import org.springframework.stereotype.Component;

/**
 * @author chen jia
 * @date 2020/12/4 14:48
 */

@Component
public class DatasourceManageCenter {

    public String getSlaveDatasourceKey() {
        return "slave1";
    }

    public String getMaterDatasourceKey() {
        return "master";
    }
}
