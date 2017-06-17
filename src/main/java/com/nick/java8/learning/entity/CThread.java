package com.nick.java8.learning.entity;

/**
 * Created by nick on 2017/6/12.
 */
public class CThread implements Runnable {

    private Consumer consumer;

    public CThread(Consumer consumer){
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while (true){
            consumer.popService();
        }
    }
}
