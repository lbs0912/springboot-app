package com.lbs0912.springboot.app.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class InitHelloWorld implements BeanPostProcessor, Ordered {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[BeanPostProcessor] BeforeInitialization : " + beanName);
        System.out.println("[BeanPostProcessor] BeforeInitialization getClass : " + bean.getClass()); //class com.lbs0912.springboot.app.service.HelloWorld


        return bean;  // you can return any other object as well
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[BeanPostProcessor] AfterInitialization : " + beanName);
        return bean;  // you can return any other object as well
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
