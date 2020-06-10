package com.lbs0912.springboot.app.utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

/**
 * @author liubaoshuai1
 */
public class WebUtils {

    private static final Logger log = LoggerFactory.getLogger(WebUtils.class);

    private static Gson gson = new GsonBuilder().serializeNulls().create();

    /**
     * 返回json数据
     *
     * @param response
     * @param object
     */
    public static void writeJson(HttpServletResponse response, int status, Object object) {
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(status);
        PrintWriter out = null;
        try {
            String data = object instanceof String ? (String) object : gson.toJson(object);
            out = response.getWriter();
            out.print(data);
            out.flush();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 返回json数据
     *
     * @param response
     * @param object
     */
    public static void writeJson(HttpServletResponse response, Object object) {
        writeJson(response, HttpServletResponse.SC_OK, object);
    }

    /**
     * 返回json数据
     *
     * @param response
     * @param object
     */
    public static void writeJson(ServletResponse response, Object object) {
        if (response instanceof HttpServletResponse) {
            writeJson((HttpServletResponse) response, object);
        }
    }
}
