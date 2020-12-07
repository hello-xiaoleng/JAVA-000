package com.xiaoleng.datasource02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author chenjia
 * @date 2020/12/07
 */
@EnableAspectJAutoProxy
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Datasource02Application {

    public static void main(String[] args) {
        SpringApplication.run(Datasource02Application.class, args);
    }

}
