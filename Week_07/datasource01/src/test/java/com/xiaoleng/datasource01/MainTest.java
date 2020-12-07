package com.xiaoleng.datasource01;

import com.alibaba.druid.support.json.JSONUtils;
import com.xiaoleng.datasource01.config.ManageCenter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author chen jia
 * @date 2020/12/3 20:15
 */

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MainTest {

    @Resource
    private OrderService orderService;

    @Resource
    private ManageCenter manageCenter;

    @Test
    public void testQuery() {

        List<Map<String, Object>> dataList = orderService.query(manageCenter.getMaterDatasource(), "select * from test");

        log.info("result:{}", JSONUtils.toJSONString(dataList));

        log.info("impl:{}", log.getClass().getName());

    }

    @Test
    public void testWrite() {
        String sql = MessageFormat.format("insert into test(user_name) values(''{0}'')", "lisi");
        orderService.insertOne(manageCenter.getMaterDatasource(), sql);

    }
}
