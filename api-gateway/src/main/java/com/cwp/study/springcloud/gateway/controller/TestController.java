package com.cwp.study.springcloud.gateway.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
public class TestController {

    private final RestTemplate restTemplate;

    @Autowired
    public TestController(RestTemplate restTemplate) {this.restTemplate = restTemplate;}

    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {
        return restTemplate.getForObject("http://data-manager-service/data-manager/echo/" + str, String.class);
    }

    @RequestMapping(value = "/test")
    public String queryUserByUserId(){
        return  restTemplate.getForObject("http://system-center-web/system-center/user/queryUserByUserId?userId=1 ",String.class);
    }
}
