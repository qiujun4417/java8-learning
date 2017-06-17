package com.nick.java8.learning.lock;

/**
 * Created by nick on 2017/6/17.
 */
public class QueueFactory {

    private static Queue queue;

    public static Queue getQueueInstance(){
        if(queue == null){
            synchronized (QueueFactory.class){
                if(queue == null){
                    queue = new Queue();
                }
            }
        }
        return queue;
    }
}
