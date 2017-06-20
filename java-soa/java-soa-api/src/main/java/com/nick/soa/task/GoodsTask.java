package com.nick.soa.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

/**
 * Created by ningyang on 2017/6/20.
 */
public class GoodsTask implements Callable {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private AsyncContext asyncContext;
    private Callable task;
    private String uri;

    public GoodsTask(AsyncContext asyncContext, Callable task, String uri){
        this.asyncContext = asyncContext;
        this.task = task;
        this.uri = uri;
    }

    @Override
    public Object call() throws Exception {
        Object result = task.call();
        if(result == null)
            callback(result, uri);
        if(result instanceof CompletableFuture){
            CompletableFuture<Object> future = (CompletableFuture) result;
            future.thenAccept(resultObj -> callback(resultObj, uri)).exceptionally(e -> {callback("", uri);
            return null;}
            );
        }else if(result instanceof String){
            callback(result, uri);
        }

        return null;
    }

    private void callback(Object result, String uri){
        HttpServletResponse response = (HttpServletResponse) asyncContext.getResponse();
        try{
            if(result!=null && result instanceof String){
                write(response, (String) result);
            }else{
                write(response, "");
            }
        }catch (Throwable throwable){
            logger.error("get info error in uri : {}", uri, throwable);
        }
    }

    private void write(HttpServletResponse response, String result){
        try{
            PrintWriter writer = response.getWriter();
            response.setContentType("application/json;charset=UTF-8");
            writer.write(result);
            writer.flush();
            asyncContext.complete();
        } catch (IOException e) {
            //
        }
    }

    public AsyncContext getAsyncContext(){
        return this.asyncContext;
    }
}
