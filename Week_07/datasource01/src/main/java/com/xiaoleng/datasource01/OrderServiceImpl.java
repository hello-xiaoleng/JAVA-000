package com.xiaoleng.datasource01;

import com.xiaoleng.datasource01.config.Read;
import com.xiaoleng.datasource01.config.Write;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author chen jia
 * @date 2020/12/3 20:48
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    @Write
    public void insertOne(DataSource dataSource, String sql) {
        try {
            JdbcUtil.insert(dataSource, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Read
    public List<Map<String, Object>> query(DataSource dataSource, String sql) {
        try {
            return JdbcUtil.listData(dataSource, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
