package com.link.jk.jkframework.service;

import com.link.jk.jkframework.dao.TestDao;
import com.link.jk.jkframework.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class TestService {

    @Resource
    private TestMapper testMapper;
    @Resource
    private TestDao testDao;

    public List<HashMap<String, Object>> getTests() {
        return testMapper.selectTests();
    }

    public List<HashMap<String, Object>> getTestsWithDao() {
        return testDao.getTests();
    }

}
