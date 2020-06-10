package com.lbs0912.springboot.app.common;


import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;





/**
 * API 统一返回结果
 * @author liubaoshuai1
 * @date 2020-06-10 11:21
 */

@Slf4j
@Getter
@Setter
public class ApiResult<T> implements Serializable {

    private static final long serialVersionUID = 2538767816320181885L;

    protected Integer code;

    protected T data;

    protected String message;

    public ApiResult() {
    }

    public ApiResult(Integer code) {
        this(code, null, null);
    }

    public ApiResult(Integer code, T data) {
        this(code, data, null);
    }

    public ApiResult(Integer code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static ApiResult success() {
        return success(null);
    }

    public static <T> ApiResult<T> success(T data) {
        ApiResult apiResult = withCode(ResultCode.SUCCESS);
        apiResult.setData(data);
        return apiResult;
    }

    public static ApiResult fail(String message) {
        ApiResult apiResult = withCode(ResultCode.FAIL);
        apiResult.setMessage(message);
        return apiResult;
    }

    public static ApiResult withCode(ResultCode resultCode) {
        return withCode(resultCode, null);
    }

    public static <T> ApiResult<T> withCode(ResultCode resultCode, T data) {
        return new ApiResult(resultCode.getCode(), data, resultCode.getMessage());
    }
}
