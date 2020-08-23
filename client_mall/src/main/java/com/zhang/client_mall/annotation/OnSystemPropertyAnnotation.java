package com.zhang.client_mall.annotation;

import com.zhang.client_mall.config.OnSystemPropertyCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * @author zhang
 * @date 2020-08-21
 * @descript
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface OnSystemPropertyAnnotation {

    String name();

    String value();
}
