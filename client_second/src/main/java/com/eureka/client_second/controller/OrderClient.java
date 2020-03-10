package com.eureka.client_second.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "first-client")
public interface OrderClient {
    @GetMapping("/product/getUserName")
    String feignGetList(@RequestParam("userName") String userName);
}
