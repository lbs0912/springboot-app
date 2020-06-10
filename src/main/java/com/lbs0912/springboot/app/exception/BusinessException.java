package com.lbs0912.springboot.app.exception;



/**
 * 业务异常
 * @author lbs
 * @date 2020-06-10 11:21
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
