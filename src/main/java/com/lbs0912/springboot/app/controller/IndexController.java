package com.lbs0912.springboot.app.controller;


import com.lbs0912.springboot.app.common.ApiResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 *
 * @author liubaoshuai1
 * @date 2020-06-10 11:21
 */

@Api(description = "IndexController服务-Swagger测试")
@RestController
public class IndexController extends BaseController{
    // localhost:8080/swagger-ui.html
    @GetMapping("/index/{name}")
    @ApiOperation(value = "Hello World", notes = "Hello World + name")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", required = true)
    })

    public String index(@PathVariable String name){
        return  "Hello World " + name;
    }

    @GetMapping("/index")
    public ApiResult<String> index() {
        return ApiResult.success("Hello World");
    }

    @GetMapping("/test")
    public ApiResult<String> testError() {
        System.out.println(1 / 0);
        return ApiResult.fail("error");
    }
}
