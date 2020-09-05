package com.cwp.study.springcloud.provider.controller;

import com.cwp.study.springcloud.provider.service.test.TestHiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/hive")
@RestController
public class HiveController {

    @Autowired
    private TestHiveService testHiveService;

    @RequestMapping("/create")
    public Map testCreate(){
        Map map =new HashMap();
        testHiveService.testCreate();
        return map;
    }

    @RequestMapping("/delete")
    public Map testDelete(){
        Map map =new HashMap();
        testHiveService.testDelete();
        return map;
    }


    @RequestMapping("/insert")
    public Map testInsert(){
        Map map =new HashMap();
        testHiveService.testInsert();
        return map;
    }


    @RequestMapping("/select")
    public Map test(){
        Map map =new HashMap();
        testHiveService.testSelect();
        return map;
    }
}
