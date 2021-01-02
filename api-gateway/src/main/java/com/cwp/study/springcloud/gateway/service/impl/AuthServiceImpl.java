package com.cwp.study.springcloud.gateway.service.impl;


import cn.hutool.core.collection.CollectionUtil;
import com.cwp.study.springcloud.gateway.model.dto.ApiGatewayConfig;
import com.cwp.study.springcloud.gateway.service.AuthService;
import com.cwp.study.springcloud.gateway.service.PathMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthServiceImpl implements AuthService {



   @Autowired
   private PathMatchService pathMatchService;

   @Autowired
   private ApiGatewayConfig apiGatewayConfig;




    @Override
    public boolean skipAuth(String url){
       List<String> skipAuthUrls =apiGatewayConfig.getSkipUrls();
        boolean flag=false;
        if(CollectionUtil.isNotEmpty(skipAuthUrls)){
           for(String pattern:skipAuthUrls){
               flag = pathMatchService.pathMatches(pattern,url);
               if(flag==true){
                   break;
               }
           }
        }
       return flag;
    }


    @Override
    public boolean checkToken(String token){
        return true;
    }
}
