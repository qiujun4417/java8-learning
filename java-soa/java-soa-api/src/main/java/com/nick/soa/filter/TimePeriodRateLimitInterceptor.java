package com.nick.soa.filter;

import com.nick.soa.ratelimit.TimePeriodRateLimit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by nick on 2017/6/22.
 */
public class TimePeriodRateLimitInterceptor extends AbstractInterceptor{

    private Logger logger = LoggerFactory.getLogger(getClass());
    private TimePeriodRateLimit timePeriodRateLimit;

    public TimePeriodRateLimitInterceptor(TimePeriodRateLimit timePeriodRateLimit){
        this.timePeriodRateLimit = timePeriodRateLimit;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if(!timePeriodRateLimit.rateLimit()){
            buildResponse(httpServletResponse, 0, "exceed limit");
            logger.error("thread {} exceed limit and failed", Thread.currentThread().getName());
            return false;
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
