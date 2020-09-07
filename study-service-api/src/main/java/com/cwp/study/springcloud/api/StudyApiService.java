package com.cwp.study.springcloud.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/api")
public interface   StudyApiService {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello();
}
