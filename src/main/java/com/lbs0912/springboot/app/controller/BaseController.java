package com.lbs0912.springboot.app.controller;

import com.lbs0912.springboot.app.common.ApiResult;
import com.lbs0912.springboot.app.common.BaseCommon;
import com.lbs0912.springboot.app.exception.BusinessException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * 控制器基类
 *
 * @author lbs
 * @date 2020-06-10 11:21
 */
@Slf4j
public abstract class BaseController {


    /**
     * BusinessException 异常处理
     */
    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public ApiResult businessExceptionHandler(BusinessException e) {
        log.error(e.getMessage(), e);
        // do something
        return ApiResult.fail(e.getMessage());
    }

    /**
     * Exception 异常处理
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ApiResult exceptionHandler(Exception e) {
        log.error(e.getMessage(), e);
        return ApiResult.fail("服务异常，请稍后重试");
    }

    /**
     * 获得当前用户编号
     */
    public String getCurrentUserCode() {
        //TODO 待实现
        return null;
    }

    /**
     * 设置创建信息
     */
    public void setCreateInfo(BaseCommon baseCommon) {
        baseCommon.setCreateUser(getCurrentUserCode());
        baseCommon.setCreateTime(new Date());
        setModifyInfo(baseCommon);
    }

    /**
     * 设置修改信息
     */
    public void setModifyInfo(BaseCommon baseCommon) {
        baseCommon.setModifyUser(getCurrentUserCode());
        baseCommon.setModifyTime(new Date());
    }
}



