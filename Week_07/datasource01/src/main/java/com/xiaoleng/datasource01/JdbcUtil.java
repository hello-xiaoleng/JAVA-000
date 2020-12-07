package com.xiaoleng.datasource01;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chen jia
 * @date 2020/12/4 13:12
 */
public class JdbcUtil {


    public static List<Map<String, Object>> listData(DataSource dataSource, String url) throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(url);

        List<Map<String, Object>> rowMap = new ArrayList<>();
        Map<String, Object> columnMap = new HashMap<>();
        while (resultSet.next()) {

            ResultSetMetaData rsMeta = resultSet.getMetaData();
            int columnCount = rsMeta.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columnMap.put(rsMeta.getColumnLabel(i), resultSet.getObject(i));
            }
            rowMap.add(columnMap);
        }

        return rowMap;
    }

    public static void insert(DataSource dataSource, String url) throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.execute(url);
    }
}
