package com.nick.java8.learning.entity;

/**
 * Created by nick on 2017/6/12.
 */
public class Consumer {

    private MyStack stack;

    public Consumer(MyStack stack){
        this.stack = stack;
    }

    public void popService(){
        System.out.println("pop=" + stack.pop());
    }
}
