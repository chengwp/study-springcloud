package com.cwp.study.springcloud.gateway.service;


public interface PathMatchService {


    boolean pathMatches(String pattern, String path);
}
