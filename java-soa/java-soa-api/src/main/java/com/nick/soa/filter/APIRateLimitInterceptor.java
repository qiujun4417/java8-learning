package com.nick.soa.filter;

import com.nick.soa.ratelimit.APIRateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by nick on 2017/6/22.
 */
public class APIRateLimitInterceptor extends AbstractInterceptor{

    private Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * api限流器
     * 当某一个api调用量超过设置阈值时则返回超流量错误
     */
    private APIRateLimiter apiRateLimiter;

    public APIRateLimitInterceptor(APIRateLimiter apiRateLimiter){
        this.apiRateLimiter = apiRateLimiter;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        try{
            String uri = httpServletRequest.getRequestURI();
            apiRateLimiter.setUri(uri);
            if(!apiRateLimiter.rateLimit()){
                buildResponse(httpServletResponse, 0, "exceed limit");
                logger.error("Thread: {} request {} exceed call limit ", Thread.currentThread().getName(), uri);
                return false;
            }
            Thread.sleep(300);
        }finally {
            apiRateLimiter.callback();
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
