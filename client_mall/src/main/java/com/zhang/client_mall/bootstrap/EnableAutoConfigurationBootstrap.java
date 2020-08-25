package com.zhang.client_mall.bootstrap;

import com.zhang.client_mall.service.CalculateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author zhang
 * @date 2020-08-25
 * @descript
 */
@EnableAutoConfiguration
@Slf4j
public class EnableAutoConfigurationBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableAutoConfigurationBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);
        CalculateService calculateService = context.getBean(CalculateService.class);
        log.info("获取上下文中的bean：{}",calculateService.sum(1,2,2,3,4));
        context.close();
    }
}
