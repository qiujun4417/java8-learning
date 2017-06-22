package com.nick.soa.ratelimit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by nick on 2017/6/22.
 */
public class TimePeriodRateLimit extends AbstractRateLimiter{

    private Logger logger = LoggerFactory.getLogger(getClass());
    private volatile AtomicInteger count = new AtomicInteger(0);
    private Integer limitCount;
    private LoadingCache<Long, AtomicLong> counter;

    public TimePeriodRateLimit(Integer limitCount){

        this.limitCount = limitCount;
        this.counter = CacheBuilder.newBuilder().
                expireAfterWrite(2, TimeUnit.SECONDS).build(new CacheLoader<Long, AtomicLong>() {
            @Override
            public AtomicLong load(Long key) throws Exception {
                return new AtomicLong(0);
            }
        });
    }

    @Override
    public boolean rateLimit() throws InterruptedException {
        long currentSeconds = System.currentTimeMillis() / 1000;
        try {
            if(counter.get(currentSeconds).incrementAndGet() > limitCount){
                return false;
            }
        } catch (ExecutionException e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            logger.error(sw.toString());
        }
        return true;
    }

    @Override
    public void callback() {

    }
}
