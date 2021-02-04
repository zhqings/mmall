package com.zhang.client_mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.zhang.client_mall.servlet")
public class ClientMallApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientMallApplication.class, args);
    }

}
