package com.eureka.client_first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientFirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientFirstApplication.class, args);
    }

}
