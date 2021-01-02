package com.cwp.study.springcloud.gateway.config;



import com.cwp.study.springcloud.gateway.threadlocal.RequestHeaderThreadLocal;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;

/**
 * @ClassName FeignConfiguration
 * @Description TODO
 * @Author Getech
 * @Date 2020/12/23 15:23
 */
@Configuration
public class FeignConfiguration implements RequestInterceptor {

    /**
    * @Description 将请求头中的参数，全部作为 feign 请求头参数传递
    * @Author  chengweiping
    * @Date   2020/12/23 15:30
    */
    @Override
    public void apply(RequestTemplate requestTemplate) {

            ServerHttpRequest serverHttpRequest=RequestHeaderThreadLocal.get();
            if(serverHttpRequest==null){
                return;
            }else{
               HttpHeaders httpHeaders= serverHttpRequest.getHeaders();
               httpHeaders.entrySet().stream().forEach(e->{
                    requestTemplate.header(e.getKey(),e.getValue());
                });
            }
        }

}
