package com.xiaoleng.datasource02.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class TestServiceTest {

    @Autowired
    private TestService testService;

    @Test
    public void test() {
        com.xiaoleng.datasource02.domain.entity.Test test =new com.xiaoleng.datasource02.domain.entity.Test();
        test.setUserName("zhangsan");
        testService.insert(test);

        List<com.xiaoleng.datasource02.domain.entity.Test> list = testService.findAll();
        log.info(list.toString());
    }


}