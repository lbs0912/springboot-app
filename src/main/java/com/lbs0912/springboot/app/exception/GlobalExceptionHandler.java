package com.lbs0912.springboot.app.exception;


import com.lbs0912.springboot.app.common.ApiResult;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

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
}
