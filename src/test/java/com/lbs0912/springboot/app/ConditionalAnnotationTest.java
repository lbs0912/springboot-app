package com.lbs0912.springboot.app;

import com.lbs0912.springboot.app.config.BeanConfig;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.lbs0912.springboot.app.entity.System;
import java.util.Map;


/**
 * @Conditional 注解 https://juejin.cn/post/6844904200401321997
 */
public class ConditionalAnnotationTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);

    @Test
    public void test1() {
        Map<String, System> beans = applicationContext.getBeansOfType(System.class);
        java.lang.System.out.println(beans);
    }

    @Test
    public void test2() {

        String osName = applicationContext.getEnvironment().getProperty("os.name");
        java.lang.System.out.println(osName);
        Map<String, System> beans = applicationContext.getBeansOfType(System.class);
        java.lang.System.out.println(beans);
    }

}
