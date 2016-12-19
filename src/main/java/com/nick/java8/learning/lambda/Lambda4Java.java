package com.nick.java8.learning.lambda;

/**
 * Created by nick on 2016/12/6.
 * @author nick
 */
public class Lambda4Java {

    public static void main(String[] args){
        new Thread(()->System.out.println("hello world")).start();
    }
}
