package com.cwp.study.springcloud.provider.service.test.impl;

import com.cwp.study.springcloud.provider.dao.hive.test.TestHiveDao;
import com.cwp.study.springcloud.provider.service.test.TestHiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class TestHiveServiceImpl implements TestHiveService {

    @Autowired
    private TestHiveDao testHiveDao;

    @Override
    public HashMap test(){
        testHiveDao.test();
        return new HashMap();
    }

    @Override
    public void testInsert(){
        testHiveDao.testInsert();
    }

    @Override
    public void testCreate(){
        testHiveDao.testCreateTable();
    }

    @Override
    public void testDelete(){
        testHiveDao.testDelete();
    }

    @Override
    public void testSelect(){
        testHiveDao.testSelect();
    }
}
