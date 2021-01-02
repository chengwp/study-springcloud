package com.cwp.study.springcloud.gateway.filter;

import com.cwp.study.springcloud.gateway.service.AuthService;
import com.cwp.study.springcloud.gateway.threadlocal.RequestHeaderThreadLocal;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Objects;


@Component
@Slf4j
public class AuthorizationFilter implements GlobalFilter, Ordered {



    @Autowired
    private AuthService authService;



    /**
     * 过滤器
     *
     * @param exchange  链路处理
     * @param chain 拦截或放行
     * @return 鉴权结果
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token=null;
        //获取请求
        ServerHttpRequest serverHttpRequest = exchange.getRequest();
        //把请求设置到本地线程中
        RequestHeaderThreadLocal.set(serverHttpRequest);
        String url = exchange.getRequest().getURI().getPath();
        //去除掉上下文，然后对url进行白名单验证
        ServerHttpResponse resp = exchange.getResponse();
        int fromIndex=url.indexOf("/",1);
        String afterUrl=null;
        if(fromIndex!=-1){
             afterUrl= url.substring(fromIndex);
        }else{
             afterUrl=url;
        }
        log.info("当前请求url={},截取上下文后的url={}",url,afterUrl);
        //跳过不需要验证的路径，该路径写在了配置文件中
        boolean skipAuthFlag=authService.skipAuth(afterUrl);
        if (skipAuthFlag) {
            RequestHeaderThreadLocal.remove();
            return chain.filter(exchange);
        }
        //获取请求token
        token= getRequestToken(exchange);
        if (StringUtils.isBlank(token)) {
            RequestHeaderThreadLocal.remove();
            //没有token
            return authErro(resp, "您没有无权限访问，token为空,请先登录");
        } else {
            //有token
            try {
                boolean tokenFlag = this.authService.checkToken(token);
                if (tokenFlag) {

                    //把请求设置到本地线程中
                    RequestHeaderThreadLocal.remove();
                    return chain.filter(exchange);
                }else {
                    RequestHeaderThreadLocal.remove();
                    return authErro(resp, "您的认证权限已过期，请重新进行认证");

                }
            } catch (Exception e) {
                log.error("校验权限失败", e);
                RequestHeaderThreadLocal.remove();
                return authErro(resp, e.getMessage());

            }

        }

    }

    /**
     * 获取请求的token
     */
    private String getRequestToken(ServerWebExchange exchange){
        String token=null;
        try{
            token = Objects.requireNonNull(exchange.getRequest().getHeaders().getFirst("token")).trim();
            if(StringUtils.isBlank(token)){
                Objects.requireNonNull(exchange.getRequest().getQueryParams().getFirst("token")).trim();
            }
        }catch (Exception e){
            log.error("获取token异常",e);
        }

        return token;
    }

    /**
     * 认证错误输出
     *
     * @param resp 响应对象
     * @param msg 错误信息
     * @return 错误结果
     */
    private Mono<Void> authErro(ServerHttpResponse resp, String msg) {
        Gson gson=new Gson();
        resp.setStatusCode(HttpStatus.UNAUTHORIZED);
        resp.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("msg",msg);
        jsonObject.addProperty("flag",false);
        String returnStr = "";
        try {
            returnStr = jsonObject.toString();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        DataBuffer buffer = resp.bufferFactory().wrap(returnStr.getBytes(StandardCharsets.UTF_8));
        //把请求到从本地线程中移除
         RequestHeaderThreadLocal.remove();
        return resp.writeWith(Flux.just(buffer));
    }





    @Override
    public int getOrder() {
        return -1;
    }
}
