package com.lbs0912.springboot.app.controller;


import com.lbs0912.springboot.app.common.ApiResult;
import com.lbs0912.springboot.app.entity.User;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Pattern;

/**
 * @author lbs
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @PostMapping("/add")
    public ApiResult addUser(@RequestBody User user) {
        if (user == null) {
            return ApiResult.fail("对象不能为空");
        }
        if (StringUtils.isEmpty(user.getAccount()) || StringUtils.isEmpty(user.getPassword()) || StringUtils.isEmpty(user.getEmail())) {
            return ApiResult.fail("账号、密码或邮箱不能为空");
        }
        if (user.getAccount().length() < 6 || user.getAccount().length() > 11) {
            return ApiResult.fail("账号长度必须是6-11个字符");
        }
        if (user.getPassword().length() < 6 || user.getPassword().length() > 16) {
            return ApiResult.fail("密码长度必须是6-16个字符");
        }
        if (!Pattern.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", user.getEmail())) {
            return ApiResult.fail("邮箱格式不正确");
        }
        // 新增用户操作
        return ApiResult.success();
    }
}
