package com.nick.java8.learning.lock;

/**
 * Created by nick on 2017/6/17.
 */
public class LocksMapFactory {

    private static LockMap lockMap;

    public static LockMap getLockMapInstance(){
        if(lockMap == null){
            synchronized (LocksMapFactory.class){
                if(lockMap == null){
                    lockMap = new LockMap();
                }
            }
        }
        return lockMap;
    }
}
