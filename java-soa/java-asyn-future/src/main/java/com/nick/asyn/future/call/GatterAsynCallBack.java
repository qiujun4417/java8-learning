package com.nick.asyn.future.call;

import com.google.common.collect.Lists;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * Created by ningyang on 2017/6/26.
 */
public class GatterAsynCallBack {

    public void getterAasynCallBack() throws ExecutionException, InterruptedException {
        final RequestConfig requestConfitg = RequestConfig.custom()
                .setSocketTimeout(3000)
                .setConnectTimeout(3000).build();
        final CloseableHttpAsyncClient httpAsyncClient = HttpAsyncClients.custom().
                setDefaultRequestConfig(requestConfitg).
                build();
        httpAsyncClient.start();
        AsynCallBack asynCallBack = new AsynCallBack(httpAsyncClient);
        CompletableFuture<String> future1 = asynCallBack.getHttpData("http://www.baidu.com");
        CompletableFuture<String> future2 = asynCallBack.getHttpData("http://www.apache.org");
        CompletableFuture<String> future3 = asynCallBack.getHttpData("http://www.oschina.net");
        List<CompletableFuture> futureList = Lists.newArrayList(future1, future2, future3);
        CompletableFuture<Void> allDoneFuture = CompletableFuture.allOf(futureList.
                toArray(new CompletableFuture[futureList.size()]));
        CompletableFuture<String> future4 = allDoneFuture.thenApply(v->{
            List<Object> result = futureList.stream().map(CompletableFuture::join).collect(Collectors.toList());
            String result1 = (String) result.get(0);
            String result2 = (String) result.get(1);
            String result3 = (String) result.get(2);
            return result1 + result2 + result3;
        }).exceptionally(e->{
            e.printStackTrace();
            return "";
        });
        String result4 = future4.get();
        System.out.println(result4);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        GatterAsynCallBack gatterAsynCallBack = new GatterAsynCallBack();
        gatterAsynCallBack.getterAasynCallBack();
    }
}
