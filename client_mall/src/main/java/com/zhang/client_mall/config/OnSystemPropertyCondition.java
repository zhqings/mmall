package com.zhang.client_mall.config;


import com.zhang.client_mall.annotation.OnSystemPropertyAnnotation;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @author zhang
 * @date 2020-08-21
 * @descript
 */
public class OnSystemPropertyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Map<String, Object> map = annotatedTypeMetadata.getAnnotationAttributes(OnSystemPropertyAnnotation.class.getName());
        String name = String.valueOf(map.get("name"));
        String value = String.valueOf(map.get("value"));
        String OValue = System.getProperty(name);
        return value.equals(OValue);
    }
}
