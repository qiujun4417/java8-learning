package com.nick.soa.ratelimit;

/**
 * Created by nick on 2017/6/22.
 */
public abstract class AbstractRateLimiter {

    public abstract boolean rateLimit() throws InterruptedException;

    public abstract void callback();
}
