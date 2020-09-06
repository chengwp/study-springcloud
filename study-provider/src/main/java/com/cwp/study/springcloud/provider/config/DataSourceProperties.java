package com.cwp.study.springcloud.provider.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@Data
@ConfigurationProperties(prefix = DataSourceProperties.DS, ignoreUnknownFields = false)
public class DataSourceProperties {

    final static String DS = "spring.datasource";

    private Map<String,String> mysql;

    private Map<String,String> hive;

    private Map<String,String> commonConfig;

}
