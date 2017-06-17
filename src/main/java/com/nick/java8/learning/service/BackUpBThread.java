package com.nick.java8.learning.service;

/**
 * Created by nick on 2017/6/13.
 */
public class BackUpBThread extends Thread {

    private BackUpService backUpService;

    public BackUpBThread(BackUpService backUpService){
        this.backUpService = backUpService;
    }

    @Override
    public void run(){
        while (true){
            backUpService.backUpB();
        }
    }
}
