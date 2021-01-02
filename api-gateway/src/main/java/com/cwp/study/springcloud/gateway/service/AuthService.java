package com.cwp.study.springcloud.gateway.service;


public interface AuthService {


    /**
     *  跳过权限验证白名单
     * @param url
     * @return
     */
    boolean skipAuth(String url);

    boolean checkToken(String token);
}
