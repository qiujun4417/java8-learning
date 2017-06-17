package com.nick.java8.learning.service;

/**
 * Created by nick on 2017/6/13.
 */
public class BackUpAThread extends Thread {

    private BackUpService backUpService;

    public BackUpAThread(BackUpService backUpService){
        this.backUpService = backUpService;
    }

    public void run(){
        while (true){
            backUpService.backUpA();
        }
    }
}
