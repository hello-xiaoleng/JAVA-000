package com.xiaoleng.datasource02.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author chenjia
 * @date 2020/12/07
 */
public class DynamicDatasource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return HandlerDataSource.getDataSource();
    }
}
