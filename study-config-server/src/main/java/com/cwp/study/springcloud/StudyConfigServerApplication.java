package com.cwp.study.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class StudyConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyConfigServerApplication.class, args);
    }

}
