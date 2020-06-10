package com.lbs0912.springboot.app.entity;


import com.lbs0912.springboot.app.common.BaseCommon;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;



/**
 * @author lbs
 */

//@TableName("sys_user")
@Getter
@Setter
public class User extends BaseCommon {

//    @TableId(type = IdType.AUTO)
    private Long id;

    @NotNull(message = "用户账号不能为空")
    @Size(min = 6, max = 11, message = "账号长度必须是6-11个字符")
    private String account;

    @NotNull(message = "用户密码不能为空")
    @Size(min = 6, max = 11, message = "密码长度必须是6-16个字符")
    private String password;

    @Size(max = 40, message = "用户昵称不能超过40个字符")
    private String nickname;

    private String email;

    private String phone;
}