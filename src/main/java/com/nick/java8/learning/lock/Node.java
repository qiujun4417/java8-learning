package com.nick.java8.learning.lock;

/**
 * Created by nick on 2017/6/17.
 */
public class Node {

    public static Integer WAIT = 1;

    public static Integer START = 0;

    private int status;

    public Node(Thread thread, Integer status){
        this.thread = thread;
        this.status = status;
    }

    public Node(Thread thread){
        this.thread = thread;
    }

    private Thread thread;

    public void setCurrent(Thread thread){
        this.thread = thread;
    }

    public Thread getThread(){
        return thread;
    }

    public void interrupt() throws InterruptedException {
        thread.wait();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
