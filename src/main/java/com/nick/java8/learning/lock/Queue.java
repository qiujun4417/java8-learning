package com.nick.java8.learning.lock;

import com.google.common.collect.Lists;

import java.util.LinkedList;

/**
 * Created by nick on 2017/6/17.
 */
public class Queue {

    private final LinkedList<Node> queue = Lists.newLinkedList();

    public synchronized Node enqueue(){
        Node node = queue.pop();
        Node next = queue.getFirst();
        if(next.getStatus() == Node.WAIT)
            next.setStatus(Node.START);
        return node;
    }

    public synchronized void queue(Node node){
        queue.addLast(node);
    }

    public synchronized Node first(){
        return queue.getFirst();
    }
}
