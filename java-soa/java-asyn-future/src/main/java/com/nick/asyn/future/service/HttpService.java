package com.nick.asyn.future.service;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by ningyang on 2017/6/26.
 * 模拟一个http请求并且线程阻塞2秒
 */
public class HttpService {

    public Map<String, String> serviceA(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Maps.newHashMap();
    }
}
