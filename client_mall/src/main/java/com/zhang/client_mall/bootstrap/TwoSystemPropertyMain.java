package com.zhang.client_mall.bootstrap;

import com.zhang.client_mall.annotation.OnSystemPropertyAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author zhang
 * @date 2020-08-21
 * @descript
 */
@EnableAutoConfiguration
@Slf4j
public class TwoSystemPropertyMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(TwoSystemPropertyMain.class)
                .web(WebApplicationType.NONE)
                .run(args);
        String hello = context.getBean("hello", String.class);
        log.info("im：{}",hello);
        context.close();
    }
}
