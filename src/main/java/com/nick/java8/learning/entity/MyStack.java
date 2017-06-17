package com.nick.java8.learning.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nick on 2017/6/12.
 */
public class MyStack {

    private final List<String> stack = new ArrayList<>();

    public synchronized void push(){
        try{
            if(stack.size()==1){
                System.out.println("栈中个数唯一 " + Thread.currentThread().getName() + " 呈wait状态");
                this.wait();
            }
            stack.add("push=" + Math.random());
            this.notify();
            System.out.println("producer push=" + stack.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized String pop(){
        String returnValue = "";
        try{
            if(stack.size()==0){
                System.out.println("pop 操作中的: " +
                Thread.currentThread().getName() + " 线程呈wait状态");
                this.wait();
            }
            returnValue = stack.get(0);
            stack.remove(0);
            this.notify();
            System.out.println("Consumer pop="+stack.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return returnValue;
    }
}
