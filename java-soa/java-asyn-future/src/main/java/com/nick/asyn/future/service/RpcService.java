package com.nick.asyn.future.service;

/**
 * Created by ningyang on 2017/6/26.
 * 一个rpc调用比如dubbo, thrift 模拟线程阻塞3秒
 */
public class RpcService {

    public String serviceB(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "serviceB";
    }
}
