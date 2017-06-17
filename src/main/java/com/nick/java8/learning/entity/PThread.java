package com.nick.java8.learning.entity;

/**
 * Created by nick on 2017/6/12.
 */
public class PThread implements Runnable {
    private Producer producer;

    public PThread(Producer producer){
        this.producer = producer;
    }

    @Override
    public void run() {
        while (true){
            producer.pushService();
        }
    }
}
