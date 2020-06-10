package com.lbs0912.springboot.app.exception;


import com.lbs0912.springboot.app.common.ApiResult;
import com.lbs0912.springboot.app.utils.WebUtils;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liubaoshuai1
 */
@Slf4j
@Component
public class GlobalHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        log.error(e.getMessage(), e);
        ApiResult apiResult;
        if (e instanceof BusinessException) {
            BusinessException be = (BusinessException) e;
            // do something
            apiResult = ApiResult.fail(be.getMessage());
        } else {
            apiResult = ApiResult.fail("服务异常，请稍后重试");
        }
        WebUtils.writeJson(response, apiResult);
        return null;
    }
}
