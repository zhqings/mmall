package com.zhang.client_mall.bootstrap;

import com.zhang.client_mall.model.AnnotationFirst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.zhang.client_mall.model")
@Slf4j
public class MyFirstMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(MyFirstMain.class)
                .web(WebApplicationType.NONE).run(args);
        AnnotationFirst annotationFirst = context.getBean("annotationFirst", AnnotationFirst.class);
        log.info("获取上下文中的bean：{}",annotationFirst);
        context.close();
    }
}
