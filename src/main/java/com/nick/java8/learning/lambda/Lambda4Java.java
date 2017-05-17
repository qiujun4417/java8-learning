package com.nick.java8.learning.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by nick on 2016/12/6.
 * @author nick
 */
public class Lambda4Java {

    public static void main(String[] args){

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello, world");
            }
        });


        Thread t2 = new Thread(()->System.out.println("hello world"));

        List<String> names = Arrays.asList("nick","mike","lily","jimmy");

        Collections.sort(names, (a, b)-> b.compareTo(a));

        for(String name: names){
            System.out.println(name);
        }
    }
}
