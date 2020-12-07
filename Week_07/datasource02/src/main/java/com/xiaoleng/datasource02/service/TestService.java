package com.xiaoleng.datasource02.service;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xiaoleng.datasource02.config.Read;
import com.xiaoleng.datasource02.config.Write;
import com.xiaoleng.datasource02.domain.entity.Test;
import com.xiaoleng.datasource02.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {

    @Resource
    private TestMapper testMapper;


    @Read
    public List<Test> findAll() {
        List<Test> list = testMapper.selectList(new LambdaQueryWrapper<>());
        return list;
    }

    @Write
    public int insert(Test test) {
        int effectRow = testMapper.insert(test);
        return effectRow;
    }

}
