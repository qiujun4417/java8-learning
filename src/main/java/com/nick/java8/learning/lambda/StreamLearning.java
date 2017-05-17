package com.nick.java8.learning.lambda;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nick on 2017/1/13.
 */
public class StreamLearning {

    public static void main(String[] args){
        List<String> collections = Arrays.asList("c","d","a","x","l","n");
        System.out.println(collections.stream().distinct().count());
        collections.stream().filter((a)->a.startsWith("a")).forEach((b)-> System.out.println(b));
    }
}
