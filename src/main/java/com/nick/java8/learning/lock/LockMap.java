package com.nick.java8.learning.lock;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by nick on 2017/6/17.
 */
public class LockMap {

    private final Map<Thread, Node> locks = Maps.newConcurrentMap();

    public Node get(Thread thread){
        return locks.get(thread);
    }

    public synchronized void add(Thread current, Node node){
        Thread t = node.getThread();
        if(t != current)
            throw new IllegalMonitorStateException();
        locks.putIfAbsent(current, node);
    }

    public synchronized void remove(Node node){
        Thread current = Thread.currentThread();
        Thread t = node.getThread();
        if(locks.get(t)==null&&locks.get(t).getThread()!=current){
            throw new IllegalMonitorStateException();
        }
        locks.remove(t);
    }
}
