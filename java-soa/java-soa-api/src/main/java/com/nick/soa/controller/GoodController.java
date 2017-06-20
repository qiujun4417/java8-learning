package com.nick.soa.controller;

import com.nick.soa.service.GoodService;
import com.nick.soa.threadpool.GoodsThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.Callable;

/**
 * Created by ningyang on 2017/6/20.
 */
@RestController
@RequestMapping(value = "/api/good")
public class GoodController {

    @Autowired
    private GoodService goodService;
    @Autowired
    private GoodsThreadContext goodsThreadContext;

    @GetMapping(value = "get")
    public void getGoods(HttpServletRequest request){
        goodsThreadContext.submitFuture(request, () -> {
            goodService.getGoods();
            return "hello";
        });
    }
}
