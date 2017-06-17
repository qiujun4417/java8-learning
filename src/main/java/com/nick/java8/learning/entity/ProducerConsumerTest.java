package com.nick.java8.learning.entity;

/**
 * Created by nick on 2017/6/12.
 */
public class ProducerConsumerTest {

    public static void main(String[] args){
        MyStack myStack = new MyStack();
        Consumer consumer = new Consumer(myStack);
        Producer producer = new Producer(myStack);
        Thread p = new Thread(new PThread(producer),"Producer");
        Thread c = new Thread(new CThread(consumer), "Consumer");
        p.start();
        c.start();
    }
}
