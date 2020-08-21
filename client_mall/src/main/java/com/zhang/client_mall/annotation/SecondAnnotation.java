package com.zhang.client_mall.annotation;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@FristAnnotation
public @interface SecondAnnotation {

    String value() default "";
}
