package com.lbs0912.springboot.app.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author liubaoshuai1
 * @date 2020-06-10 11:21
 */
@RestController
public class IndexController {
    @GetMapping("index")
    public String index(){
        return  "Hello World";
    }
}
