package com.nick.java8.learning.service;

/**
 * Created by nick on 2017/6/13.
 */
public class BackUpDatabase {

    public static void main(String[] args){

        BackUpService backUpService = new BackUpService();
        for(int i=0; i<20; i++){
            BackUpAThread backUpAThread = new BackUpAThread(backUpService);
            BackUpBThread backUpBThread = new BackUpBThread(backUpService);
            backUpAThread.start();
            backUpBThread.start();
        }
    }
}
