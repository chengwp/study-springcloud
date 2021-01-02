package com.cwp.study.springcloud.gateway.threadlocal;

import org.springframework.http.server.reactive.ServerHttpRequest;

import java.io.Serializable;


public class RequestHeaderThreadLocal {

    private static ThreadLocal<ServerHttpRequest> objectHolder = new ThreadLocal<ServerHttpRequest>();

    public static void set(ServerHttpRequest serverHttpRequest){
        objectHolder.set(serverHttpRequest);
    }

    public static void remove(){
        objectHolder.remove();
    }

    public static ServerHttpRequest get(){
        ServerHttpRequest serverHttpRequest=null;
       Object object= objectHolder.get();
       if(object!=null){
           serverHttpRequest=(ServerHttpRequest)object;
       }
       return serverHttpRequest;
    }

}
