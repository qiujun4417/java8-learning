package com.nick.soa.ratelimit;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by nick on 2017/6/22.
 */
public class APIRateLimiter extends AbstractRateLimiter{

    private List<String> limitUris;

    private volatile AtomicInteger count = new AtomicInteger(0);
    private String uri;
    private Integer totalCount;

    public APIRateLimiter(List<String> limitUris, Integer totalCount){
        this.limitUris = limitUris;
        this.totalCount = totalCount;
    }

    @Override
    public boolean rateLimit() throws InterruptedException {
        if(limitUris.contains(uri)) {
            if (count.incrementAndGet() > totalCount)
                return false;
        }
        return true;
    }

    @Override
    public void callback() {
        count.decrementAndGet();
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
