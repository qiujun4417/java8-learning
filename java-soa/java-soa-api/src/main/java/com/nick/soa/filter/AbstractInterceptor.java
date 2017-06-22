package com.nick.soa.filter;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by nick on 2017/6/22.
 */
public abstract class AbstractInterceptor implements HandlerInterceptor {

    protected void buildResponse(HttpServletResponse response, int code, String msg) {
        try {
            PrintWriter writer = response.getWriter();
            response.setContentType("application/json;charset=UTF-8");
            writer.write(String.format("{\"code\":%d,\"msg\":\"%s\"}", code, msg));
            writer.close();
        } catch (IOException e) {
            //ignore
        }
    }
}
