package com.cwp.study.springcloud.consumer.feign;

import com.cwp.study.springcloud.api.StudyApiService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "study-provider")
public interface FeignApiService extends StudyApiService {
}
