package com.nick.java8.learning.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by nick on 2017/6/17.
 */
public class MyLock implements Lock {

    private volatile AtomicInteger stat = new AtomicInteger(0);

    @Override
    public void lock() {
        if(stat.compareAndSet(0,1)){

        }else {
            if (!stat.compareAndSet(0, 1)) {
//            tryLock();
                for (;;) {
                    if (stat.compareAndSet(0, 1))
                        break;
                }
            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        if(!aquireLock(1)){
            for(;;){
                if(aquireLock(1))
                    break;
            }
        }
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
//        release(0);
        stat.compareAndSet(1, 0);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    private final boolean aquireLock(int update){
        if(stat.compareAndSet(0, update)){
            return true;
        }
        return false;
    }

    private final void release(int update){
        stat.compareAndSet(1, update);
    }
}
