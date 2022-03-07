package com.lbs0912.springboot.app.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Component
@Lazy(value = false)
public class HelloWorld implements InitializingBean, DisposableBean {
    private String message;

    public HelloWorld() {
        log.info("【构造方法】HelloWorld");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("【初始化】InitializingBean afterPropertiesSet");
    }

    public void initMethod(){
        log.info("【初始化】XML init-method initMethod");
    }

    @PostConstruct
    public void postConstructMethod(){
        log.info("【初始化】@PostConstruct注解 postConstructMethod");
    }

    @PreDestroy
    public void preDestroyMethod(){
        log.info("【销毁】@PreDestroy注解 preDestroyMethod");
    }


    @Override
    public void destroy() throws Exception {
        log.info("【销毁】@DisposableBean destroy");
    }


    public void destroyMethod(){
        log.info("【销毁】XML destroy-method destroyMethod");
    }
}
