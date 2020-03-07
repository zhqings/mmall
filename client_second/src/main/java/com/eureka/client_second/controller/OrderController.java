package com.eureka.client_second.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
@Api(tags = "进程间的接口调用")
@Slf4j
public class OrderController {

    @ApiOperation(value = "进程间调用信息第一种方法")
    @GetMapping("/first")
    public String getFirst() {
        RestTemplate template = new RestTemplate();
        String response = template.getForObject("http://localhost:8081/product/getlist", String.class);
        return response;
    }

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @ApiOperation(value = "进程间调用信息第二种方法")
    @GetMapping("/second")
    public String getSecond() {
        RestTemplate template = new RestTemplate();
        ServiceInstance serviceInstance = loadBalancerClient.choose("firstclient");
        System.out.println(serviceInstance.toString());
        System.out.println(serviceInstance.getPort());
        System.out.println(serviceInstance.getInstanceId());
        System.out.println(serviceInstance.getUri());
        if (serviceInstance==null){
            log.debug("is null");
        }
        String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort())+"/product/getlist";
        System.out.println(url);
        String response = template.getForObject(url, String.class);
        log.debug("response={}",response);
        return response;
    }
}
