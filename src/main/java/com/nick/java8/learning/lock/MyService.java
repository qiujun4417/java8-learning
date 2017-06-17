package com.nick.java8.learning.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by nick on 2017/6/17.
 */
public class MyService {

//    private ReentrantLock lock = new ReentrantLock();

    private MyLock lock = new MyLock();

    public void run(){
        lock.lock();
        try{
            for(int i=0; i<10; i++){
                System.out.println(Thread.currentThread().getName() + " print " + i);
            }
        }finally {
            lock.unlock();
        }
    }
}
