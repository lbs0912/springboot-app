package com.lbs0912.springboot.app.annotation;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;


public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //获得当前系统名
        String property = conditionContext.getEnvironment().getProperty("os.name");
        //包含Windows则说明是windows系统，返回true
        return property != null && property.contains("Windows");
    }
}
