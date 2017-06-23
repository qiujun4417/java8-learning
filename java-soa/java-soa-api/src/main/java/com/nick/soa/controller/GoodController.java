package com.nick.soa.controller;

import com.nick.soa.service.GoodService;
import com.nick.soa.service.register.annotation.SoaService;
import com.nick.soa.threadpool.GoodsThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


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

    /**
     * 加上SoaService的注解就自动注册该服务
     * @param request
     */
    @GetMapping(value = "get")
    @SoaService(value = "goodsService")
    public void getGoods(HttpServletRequest request){
        goodsThreadContext.submitFuture(request, () -> {
            goodService.getGoods();
            return "hello";
        });
    }
}
