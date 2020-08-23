package com.zhang.client_mall.bootstrap;

import com.zhang.client_mall.model.AnnotationFirst;
import com.zhang.client_mall.service.CalculateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.zhang.client_mall.service")
@Slf4j
public class CalculateMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(CalculateMain.class)
                .web(WebApplicationType.NONE).profiles("java7")
                .run(args);
        CalculateService calculateService = context.getBean(CalculateService.class);
        log.info("获取上下文中的bean：{}",calculateService.sum(1,2,2,3,4));
        context.close();
    }
}
