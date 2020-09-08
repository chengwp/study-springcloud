package com.cwp.study.springcloud.consumer.controller;

import com.cwp.study.springcloud.consumer.feign.FeignApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/consumer/hello")
class ConsumerController {

    @Autowired
    private FeignApiService feignApiService;

    @RequestMapping("/test")
    public Map hello(){
        HashMap hashMap=new HashMap();
        String value= feignApiService.hello();
        hashMap.put("key",value);
        return hashMap;
    }
}
