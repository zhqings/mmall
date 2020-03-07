package com.eureka.client_second;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientSecondApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientSecondApplication.class, args);
    }

}
