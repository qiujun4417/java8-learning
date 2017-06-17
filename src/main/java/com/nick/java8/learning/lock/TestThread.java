package com.nick.java8.learning.lock;

/**
 * Created by nick on 2017/6/17.
 */
public class TestThread implements Runnable {

    private MyService myService;

    public TestThread(MyService myService){
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.run();
//        System.out.println(LocksMapFactory.getLockMapInstance().hashCode());
    }
}
