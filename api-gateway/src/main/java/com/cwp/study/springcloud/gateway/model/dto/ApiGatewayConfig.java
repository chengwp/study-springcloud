package com.cwp.study.springcloud.gateway.model.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Data
@Configuration
@ConfigurationProperties(prefix="api.gateway")
public class ApiGatewayConfig {

    private List<String> skipUrls;
}
