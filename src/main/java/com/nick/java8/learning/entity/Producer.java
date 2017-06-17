package com.nick.java8.learning.entity;

/**
 * Created by nick on 2017/6/12.
 */
public class Producer {

    private MyStack stack;

    public Producer(MyStack stack){
        this.stack = stack;
    }

    public void pushService(){
        stack.push();
    }
}
