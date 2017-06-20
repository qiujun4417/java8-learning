package com.nick.java8.learning.lock;

/**
 * Created by nick on 2017/6/17.
 */
public class MyLockTest {

    public static void main(String[] args){
        MyService myService = new MyService();
//        Thread t1 = new Thread(new TestThread(myService));
//        Thread t2 = new Thread(new TestThread(myService));
//        Thread t3 = new Thread(new TestThread(myService));
//        Thread t4 = new Thread(new TestThread(myService));
//        Thread t5 = new Thread(new TestThread(myService));
//        Thread t6 = new Thread(new TestThread(myService));
//        Thread t7 = new Thread(new TestThread(myService));
//        Thread t8 = new Thread(new TestThread(myService));
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
//        t6.start();
//        t7.start();
//        t8.start();
        for(int i=0;i<10;i++){
            Thread t = new Thread(new TestThread(myService));
            t.start();
        }
    }
}
