package com.xiaoleng.datasource01.config;

import lombok.Data;

/**
 * @author chen jia
 * @date 2020/12/3 17:22
 */

@Data
public class DatasourceDto {

    private String userName;

    private String password;

    private String url;

    private String driverClassName;
}
