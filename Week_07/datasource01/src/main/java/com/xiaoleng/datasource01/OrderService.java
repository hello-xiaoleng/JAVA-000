package com.xiaoleng.datasource01;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * @author chen jia
 * @date 2020/12/3 20:48
 */

public interface OrderService {

    void insertOne(DataSource dataSource, String sql);

    List<Map<String, Object>> query(DataSource dataSource, String sql);


}
