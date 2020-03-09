package com.eureka.client_first.controller;

import com.eureka.client_first.model.ProductInfo;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/getlist")
    public String list() {
        System.out.println("run first client2");
        return new ProductInfo(1, "桌子", 2).toString();
    }
}
