package com.lbs0912.springboot.app.service;

import com.lbs0912.springboot.app.entity.UserInfo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;
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
@Service
@Lazy(value = false)
public class HelloWorld implements InitializingBean, DisposableBean {
    private String message;
    private UserInfo userInfo;

    @Required
    public void setUserInfo(UserInfo userInfo){
        this.userInfo  = userInfo;
    }

    public void setMessage(String message){
        this.message  = message;
    }
    public String getMessage(){
//        return "Your Message : " + message;
        return "userInfo age:" + this.userInfo.getAge() + ",name:" + this.userInfo.getName();
    }



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



    public void destroy() throws Exception {
        log.info("【销毁】@DisposableBean destroy");
    }


    public void destroyMethod(){
        log.info("【销毁】XML destroy-method destroyMethod");
    }
}
