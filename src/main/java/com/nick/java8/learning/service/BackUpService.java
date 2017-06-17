package com.nick.java8.learning.service;

/**
 * Created by nick on 2017/6/13.
 */
public class BackUpService {

    private volatile boolean isPreA = false;

    public synchronized void backUpA(){
        try{
            while(isPreA){
                wait();
            }
            for(int i=0;i<5;i++){
                System.out.println("backup database A " + i);
            }
            isPreA = true;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void backUpB(){
        try{
            while (!isPreA){
                wait();
            }
            for(int i=0;i<5;i++){
                System.out.println("backup database B " + i);
            }
            isPreA = false;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
