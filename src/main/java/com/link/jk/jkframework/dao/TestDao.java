package com.link.jk.jkframework.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class TestDao {

    private SqlSession sqlSession;

    public TestDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<HashMap<String, Object>> getTests() {
        return sqlSession.selectList("com.link.jk.jkframework.mapper.TestMapper.selectTests");
    }

}
