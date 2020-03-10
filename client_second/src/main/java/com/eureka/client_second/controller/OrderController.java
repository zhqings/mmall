package com.eureka.client_second.controller;

import com.eureka.client_first.model.ProductInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
@Api(tags = "进程间的接口调用")
@Slf4j
public class OrderController {

    @ApiOperation(value = "进程间调用信息第一种方法", notes = "url接口固定")
    @GetMapping("/first")
    public String getFirst() {
        RestTemplate template = new RestTemplate();
        String response = template.getForObject("http://localhost:8081/product/getlist", String.class);
        return response;
    }

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @ApiOperation(value = "进程间调用信息第二种方法", notes = "使用服务器调用，需要导入balance获取应用名及url")
    @GetMapping("/second")
    public String getSecond() {
        RestTemplate template = new RestTemplate();
        ServiceInstance serviceInstance = loadBalancerClient.choose("first-client");
        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort()) + "/product/getlist";
        String response = template.getForObject(url, String.class);
        log.info("response={}", response);
        return response;
    }

    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation(value = "进程间调用信息第三种方法", notes = "使用服务器调用，需要添加balances配置RestTemplateConfig.java")
    @GetMapping("/third")
    public String getThird() {
        String response = restTemplate.getForObject("http://first-client/product/getlist", String.class);
        log.info("response={}", response);
        return response;
    }

    @Autowired
    private OrderClient feignClient;

    @ApiOperation(value = "进程间调用信息第四种方法", notes = "添加feign依赖，并在启动类上添加feign注解，写interface接口,接口中的参数必须有注解")
    @GetMapping("/fourth")
    public String getFourth(String userName) {
        ProductInfo tempInfo = new ProductInfo(2, "三五", 12);
        log.info(tempInfo.toString());
        String response = feignClient.feignGetList(userName);
        log.info("response={}", response);
        return response;
    }

    @ApiOperation(value = "多模块的使用", notes = "修改打包类型，最外层打方式改为pom，内层parent修改，如果使用其他包下的类需要将该包引入依赖")
    @GetMapping("/updatemodule")
    public String updateModule() {
        ProductInfo tempInfo = new ProductInfo(2, "三五", 12);
        log.info(tempInfo.toString());
//        log.info("response={}", response);
        return tempInfo.toString();
    }
}
