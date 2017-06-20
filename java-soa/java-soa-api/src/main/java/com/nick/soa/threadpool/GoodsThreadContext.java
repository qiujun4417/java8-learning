package com.nick.soa.threadpool;

import com.nick.soa.task.GoodsTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.concurrent.*;

/**
 * Created by ningyang on 2017/6/20.
 */
public class GoodsThreadContext implements InitializingBean{

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private ThreadPoolExecutor executor;
    private int corePoolSize;
    private int maxiumPoolSize;
    private LinkedBlockingDeque<Runnable> queue;
    private long keepAliveTime;
    private int asyncTimeOutInSecond;
    private AsyncListener asyncListener;

    public GoodsThreadContext(int corePoolSize, int maxiumPoolSize, long keepAliveTime, int asyncTimeOutInSecond){
        this.queue = new LinkedBlockingDeque<>();
        this.keepAliveTime = keepAliveTime;
        this.corePoolSize = corePoolSize;
        this.maxiumPoolSize = maxiumPoolSize;
        this.asyncTimeOutInSecond = asyncTimeOutInSecond;
    }

    public void submitFuture(final HttpServletRequest request, final Callable<Object> task){
        String uri = request.getRequestURI();
        AsyncContext asyncContext = request.startAsync();
        asyncContext.getRequest().setAttribute("uri", uri);
        asyncContext.setTimeout(asyncTimeOutInSecond * 1000);
        if(asyncListener !=null)
            asyncContext.addListener(asyncListener);
        GoodsTask goodsTask = new GoodsTask(asyncContext, task, uri);
        executor.submit(goodsTask);

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.executor = new ThreadPoolExecutor(corePoolSize, maxiumPoolSize,
                this.keepAliveTime, TimeUnit.SECONDS, queue);
        executor.allowCoreThreadTimeOut(true);
        executor.setRejectedExecutionHandler((r, executor) -> {
            if(r instanceof GoodsTask){
                GoodsTask gt = (GoodsTask) r;
                AsyncContext asyncContext = gt.getAsyncContext();
                if(asyncContext!=null){
                    try{
                        ServletRequest request = asyncContext.getRequest();
                        String uri = (String) request.getAttribute("uri");
                        logger.error("get error while request uri: {}", uri);
                    }catch (Exception e){
                        //
                    }finally {
                        asyncContext.complete();
                    }
                }
            }
        });
        if(asyncListener == null){
            asyncListener = new AsyncListener() {
                @Override
                public void onComplete(AsyncEvent event) throws IOException {

                }

                @Override
                public void onTimeout(AsyncEvent event) throws IOException {
                    AsyncContext asyncContext = event.getAsyncContext();
                    try{
                        ServletRequest request = asyncContext.getRequest();
                        String uri = (String) request.getAttribute("uri");
                        logger.error("get timeout while request uri: {}", uri);
                    }finally {
                        asyncContext.complete();
                    }
                }

                @Override
                public void onError(AsyncEvent event) throws IOException {

                }

                @Override
                public void onStartAsync(AsyncEvent event) throws IOException {

                }
            };
        }
    }
}
