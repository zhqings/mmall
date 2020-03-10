package com.eureka.client_third.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class Ordercontroller {
    @GetMapping("/first")
    public String first() {
        return "";
    }
}
