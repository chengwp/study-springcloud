package com.cwp.study.springcloud.provider.controller;

import com.cwp.study.springcloud.api.StudyApiService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController implements StudyApiService {

    @Override
    public String hello() {
        return "chengweiping";
    }
}
