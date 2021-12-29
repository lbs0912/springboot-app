package com.lbs0912.springboot.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.lbs0912.springboot.app.annotation.LinuxCondition;
import com.lbs0912.springboot.app.annotation.MacCondition;
import com.lbs0912.springboot.app.annotation.WindowsCondition;
import com.lbs0912.springboot.app.entity.System;



@Configuration
public class BeanConfig {

    @Conditional(WindowsCondition.class)
    @Bean(name = "windows")
    public System system1() {
        return new System("Windows");
    }

//    @Conditional(LinuxCondition.class)
    @Conditional({LinuxCondition.class,WindowsCondition.class})
    @Bean(name = "linux")
    public System system2() {
        return new System("Linux");
    }

    @Conditional(MacCondition.class)
    @Bean(name = "mac")
    public System system3() {
        return new System("Mac");
    }

}
