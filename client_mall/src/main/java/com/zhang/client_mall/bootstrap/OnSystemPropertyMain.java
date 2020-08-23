package com.zhang.client_mall.bootstrap;

import com.zhang.client_mall.annotation.OnSystemPropertyAnnotation;
import com.zhang.client_mall.service.CalculateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author zhang
 * @date 2020-08-21
 * @descript
 */

@Slf4j
public class OnSystemPropertyMain {

    @Bean
    @OnSystemPropertyAnnotation(name = "user.name",value = "zhang")
    public String hello(){
        return "hello world";
    }


    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(OnSystemPropertyMain.class)
                .web(WebApplicationType.NONE).profiles("java7")
                .run(args);
        String hello = context.getBean("hello", String.class);
        log.info("im：{}",hello);
        context.close();
    }
}
