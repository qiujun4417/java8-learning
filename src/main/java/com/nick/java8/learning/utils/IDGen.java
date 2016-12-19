package com.nick.java8.learning.utils;

import java.util.UUID;

/**
 * Created by nick on 2016/12/19.
 */
public class IDGen {

    public static String uuid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
