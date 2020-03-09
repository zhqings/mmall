package com.eureka.client_second.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "first-client")
public interface OrderClient {
    @GetMapping("/product/getlist")
    String feignGetList();
}
